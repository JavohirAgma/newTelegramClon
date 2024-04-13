package uz.pdp.ui.views;

import uz.pdp.backend.enums.GroupRole;
import uz.pdp.backend.enums.UserRole;
import uz.pdp.backend.model.chatGroup.ChatGroup;
import uz.pdp.backend.model.group.Group;
import uz.pdp.backend.model.massege.Massege;
import uz.pdp.backend.model.user.User;
import uz.pdp.backend.service.chatGroupService.ChatGroupService;
import uz.pdp.backend.service.chatGroupService.ChatGroupServiceImpl;
import uz.pdp.backend.service.groupService.GroupService;
import uz.pdp.backend.service.groupService.GroupServiceImpl;
import uz.pdp.backend.service.massegeService.MassegeService;
import uz.pdp.backend.service.massegeService.MassegeServiceImpl;
import uz.pdp.backend.service.userService.UserService;
import uz.pdp.backend.service.userService.UserServiceImpl;
import uz.pdp.ui.FrontEnd;
import uz.pdp.ui.utils.ScanUtil;

import java.util.ArrayList;
import java.util.List;

public class GroupView {
    static GroupService groupService = GroupServiceImpl.getInstance();
    static ChatGroupService chatGroupService = ChatGroupServiceImpl.getInstance();
    static MassegeService massegeService = MassegeServiceImpl.getInstance();
    static UserService userService = UserServiceImpl.getInstance();
    final static String Blue = "\033[34m";
    final static String Green = "\u001b[32m";
    final static String Reset = "\033[0m";
    public static void profile() {
        while (true){
            Integer menu = menu();
            switch (menu){
                case 1-> showGroups();
                case 2-> showMyGroups();
                case 3-> createGroup();
                case 4-> leaveGroup();
                case 0-> {
                    return;
                }
            }
        }
    }

    private static void leaveGroup() {
        List<ChatGroup> chatGroupList = chatGroupService.getGroupList(FrontEnd.curUser.getId());
        List<ChatGroup> newchatGroupList = new ArrayList<>();
        for (ChatGroup chatGroup : chatGroupList) {
            if (!chatGroup.getUserID().equals(FrontEnd.curUser.getId())){
                newchatGroupList.add(chatGroup);
            }
        }
        if (newchatGroupList.isEmpty()){
            System.out.println("There is not groups");
            return;
        }
        List<Group> groupLists = groupService.getListById(newchatGroupList);
        int i=0;
        System.out.println("Group: ");
        for (Group group : groupLists) {
            Integer res = chatGroupService.showHowUsersHave(group);
            System.out.println(++i +". "+ group.getName()+"("+res+")");
        }
        Integer index = ScanUtil.intScan("Choose group");
        index--;
        chatGroupService.deleWithGroupUserId(FrontEnd.curUser.getId(),groupLists.get(index).getId());
        System.out.println("Deleted succesfully");
    }

    public static void showGroups(){
        List<ChatGroup> chatGroupList = chatGroupService.getGroupList(FrontEnd.curUser.getId());
        List<Group> groupLists = groupService.getListById(chatGroupList);
        List<Group> listINotExist = groupService.getListINotExist(chatGroupList);
        if (chatGroupList.isEmpty()){
            List<Group> all1 = groupService.getAll();
            for (Group group : all1) {
                if(group.getRole().equals(GroupRole.PUBLIC)){
                    System.out.println(group.getName()+"    // I am not exist in this group");
                }
            }
            if (all1.isEmpty()){
                System.out.println("There is not groups");
                return;
            }
            Integer i = chooseMenu2();
            switch (i){
                case 1-> {
                    String s = joinGroup(listINotExist);
                    joiningGroup(s);
                }
            }
            again();
        }else{
            for (Group group : groupLists) {
                System.out.println(group.getName()+"      // I am exist in this groups");
            }
            List<Group> forTekshitish = new ArrayList<>();
            for (Group group : listINotExist) {
                if (group.getRole().equals(GroupRole.PUBLIC)){
                    forTekshitish.add(group);
                    System.out.println(group.getName()+"    // I am not exist in this groups");
                }
            }
            if (groupLists.isEmpty() && forTekshitish.isEmpty()){
                System.out.println("There is not groups");
            }
            if (forTekshitish.isEmpty()){
                Integer i = chooseMenu();
                switch (i) {//masseging
                    case 1 -> masseging(groupLists);
                }
            }else if(groupLists.isEmpty()){
                Integer i = chooseMenu2();
                switch (i) {
                    case 1 -> {
                        String s = joinGroup(listINotExist);
                        joiningGroup(s);
                    }
                }
            }else {
                Integer i = chooseMenu3();
                switch (i){
                    case 1->masseging(groupLists);
                    case 2->{
                        String s = joinGroup(forTekshitish);
                        joiningGroup(s);
                    }
                }
            }
        }
    }

    private static void showMyGroups() {
        List<ChatGroup> chatGroupList = chatGroupService.getGroupListForMe(FrontEnd.curUser.getId());
        List<ChatGroup> myGroups = new ArrayList<>();
        if (chatGroupList.isEmpty()){
            System.out.println("My owner groups no");
            return;
        }
        for (ChatGroup chatGroup : chatGroupList) {
            if (chatGroup.getRole().equals(UserRole.ADMIN)){
                myGroups.add(chatGroup);
            }
        }
        List<Group> groupLists = groupService.getListById(myGroups);
        int index=0;
        for (Group group : groupLists) {
            Integer i = chatGroupService.showHowUsersHave(group);
            System.out.println(++index + ". " + group.getName() + "("+i+")");
        }
        again();
        Integer i = menuForAdmin();
        switch (i){
             case 1-> showGroupMembers(myGroups);
             case 2-> addUser(myGroups);
             case 3-> userToAdmin(myGroups);
             case 4-> removeUser(myGroups);
             case 5-> editGroup(myGroups);
             case 6-> deleteGroup(myGroups);
             case 0-> {
                return;
            }
        }
    }


    private static void createGroup() {
        String nameOfGroup = ScanUtil.strScan("Enter Group name: ");
        String roleOfGroup = GroupRole.show();
        System.out.println(roleOfGroup);
        Integer ordinal = ScanUtil.intScan("Choose category: ");
        GroupRole category = GroupRole.getCategoryByOrdinal(ordinal);
        Group group = new Group(nameOfGroup, category);
        boolean b = groupService.create(group);
        if (b){
            System.out.println("Create succesfully🎉🎉🎉");
        }else{
            System.out.println("Someting wrong😑😑😑");
        }
        chatGroupService.create(new ChatGroup(FrontEnd.curUser.getId(),group.getId(), UserRole.ADMIN));
        again();
    }


///////////////////////////////////////////////////////////////////////////////// Asosiy methodlar tepada , pasdagilar yordamchi va kerakli



    private static void showGroupMembers(List<ChatGroup> myGroups) {
        List<Group> groupLists = groupService.getListById(myGroups);
        System.out.println("Groups: ");
        for (int i = 0; i < groupLists.size(); i++) {
            Integer result = chatGroupService.showHowUsersHave(groupLists.get(i));
            System.out.println((i+1) + ". " + groupLists.get(i).getName() + "("+result+")");
        }
        Integer index = ScanUtil.intScan("Choose Group: ");
        index--;
        List<ChatGroup> users = chatGroupService.getUsersList(groupLists.get(index).getId());
        List<ChatGroup> chatGroups = userService.returnForRole(users);
        List<User> users1 = userService.returnAll(users);
        for (int i = 0; i < users1.size(); i++) {
            System.out.println((i+1) + ". " + users1.get(i).getUsername()+" //"+chatGroups.get(i).getRole());
        }
        again();
    }

        private static void addUser(List<ChatGroup> myGroups) {
        List<Group> groupLists = groupService.getListById(myGroups);
        System.out.println("Groups: ");
        for (int i = 0; i < groupLists.size(); i++) {
            Integer result = chatGroupService.showHowUsersHave(groupLists.get(i));
            System.out.println((i+1) + ". " + groupLists.get(i).getName() + "("+result+")");
        }
        Integer index = ScanUtil.intScan("Choose Group: ");
        index--;
        List<ChatGroup> chatGroups = chatGroupService.joinedUser(myGroups.get(index));
        List<User> users = userService.notExistUsers(chatGroups);
        if (users.isEmpty()){
                System.out.println("Qoshadigan Users not");
                return;
        }
        for (int i = 0; i < users.size(); i++) {
                System.out.println(i+1 + ". " + users.get(i).getUsername());
        }
        Integer indexUser = ScanUtil.intScan("Choose User: ");
        indexUser--;
        User user = users.get(indexUser);
        if (myGroups.get(index).getUserID().equals(user.getId())){
            System.out.println("This user has in this group");
            again();
            return;
        }
        String roleOfuser = UserRole.show();
        System.out.println(roleOfuser);
        Integer ordinal = ScanUtil.intScan("Choose category: ");
        UserRole category = UserRole.getCategoryByOrdinal(ordinal);
        boolean b = chatGroupService.create(new ChatGroup(user.getId(), myGroups.get(index).getGroupId(), category));
        if (b){
            System.out.println("Added succesfully🎉🎉🎉");
        }else{
            System.out.println("Someting wrong😑😑😑");
        }
        again();
    }
    private static void userToAdmin(List<ChatGroup> myGroups) {
        List<Group> groupLists = groupService.getListById(myGroups);
        System.out.println("Groups: ");
        for (int i = 0; i < groupLists.size(); i++) {
            Integer result = chatGroupService.showHowUsersHave(groupLists.get(i));
            System.out.println(i+1 + ". " + groupLists.get(i).getName() + "("+result+")");
        }
        Integer index = ScanUtil.intScan("Choose Group: ");
        index--;
        List<ChatGroup> users = chatGroupService.getUsersList(groupLists.get(index).getId());
        List<User> users1 = userService.returnUser(users);
        for (int i = 0; i < users1.size(); i++) {
            System.out.println(i+1 + ". " + users1.get(i).getUsername());
        }
        if (users1.size()==1){
            System.out.println("There are only admin not user");
        }
        Integer indexUser = ScanUtil.intScan("Choose User: ");
        indexUser--;
        boolean b = chatGroupService.userToAdmin(users1.get(indexUser).getId());
        if (b){
            System.out.println("Changed successfully🎉🎉🎉");
        }else{
            System.out.println("Someting wrong😑😑😑");
        }
        again();
    }
    private static void deleteGroup(List<ChatGroup> myGroups) {
        List<Group> groupLists = groupService.getListById(myGroups);
        System.out.println("Groups: ");
        for (int i = 0; i < groupLists.size(); i++) {
            Integer result = chatGroupService.showHowUsersHave(groupLists.get(i));
            System.out.println(i+1 + ". " + groupLists.get(i).getName() + "("+result+")");
        }
        Integer index = ScanUtil.intScan("Choose Group: ");
        index--;
        chatGroupService.deleteChatGroupForGroup(groupLists.get(index).getId());
        groupService.delete(groupLists.get(index).getId());
        System.out.println("Deletd successfully");
        again();
    }

    private static void editGroup(List<ChatGroup> myGroups) {
        List<Group> groupLists = groupService.getListById(myGroups);
        System.out.println("Groups: ");
        for (int i = 0; i < groupLists.size(); i++) {
            Integer result = chatGroupService.showHowUsersHave(groupLists.get(i));
            System.out.println(i+1 + ". " + groupLists.get(i).getName() + "("+result+")");
        }
        Integer index = ScanUtil.intScan("Choose Group: ");
        index--;
        Group group = groupLists.get(index);
        String name = ScanUtil.strScan("Enter group name: ");
        String roleOfGroup = GroupRole.show();
        System.out.println(roleOfGroup);
        Integer ordinal = ScanUtil.intScan("Choose category: ");
        GroupRole category = GroupRole.getCategoryByOrdinal(ordinal);
        groupService.update(group.getId(),name,category);
        System.out.println("Udated successfully");
        again();
    }

    private static void removeUser(List<ChatGroup> myGroups) {
        List<Group> groupLists = groupService.getListById(myGroups);
        System.out.println("Groups: ");
        for (int i = 0; i < groupLists.size(); i++) {
            Integer result = chatGroupService.showHowUsersHave(groupLists.get(i));
            System.out.println(i+1 + ". " + groupLists.get(i).getName() + "("+result+")");
        }
        Integer index = ScanUtil.intScan("Choose Group: ");
        index--;
        List<ChatGroup> users = chatGroupService.getUsersList(groupLists.get(index).getId());
        List<ChatGroup> chatGroups = userService.returnForRole(users);
        List<User> users1 = userService.returnAll(users);
        List<User> newUser = new ArrayList<>();
        for (User user : users1) {
            if (!user.getId().equals(FrontEnd.curUser.getId())){
                newUser.add(user);
            }
        }
        for (int i = 0; i < newUser.size(); i++) {
            System.out.println((i+1) + ". " + newUser.get(i).getUsername()+" //"+chatGroups.get(i).getRole());
        }
        Integer i = ScanUtil.intScan("Choose: ");
        i--;
        chatGroupService.deleWithGroupUserId(newUser.get(i).getId(),groupLists.get(index).getId());
        System.out.println("Removed successufully");
        again();
    }




    private static String joinGroup(List<Group> groups) {
        List<Group> newGroups = new ArrayList<>();
        for (Group group : groups) {
            if (group.getRole().equals(GroupRole.PUBLIC)){
                newGroups.add(group);
            }
        }
        int i=0;
        for (Group group : newGroups) {
            System.out.println(++i + ". "+group.getName());
        }
        Integer index = ScanUtil.intScan("Choose: ");
        index--;
        Group group = newGroups.get(index);
        return group.getId();
    }
    private static void joiningGroup(String id) {
        boolean b = chatGroupService.create(new ChatGroup(FrontEnd.curUser.getId(), id, UserRole.USER));
        if (b){
            if (b){
                System.out.println("Joined successufully");
            }else{
                System.out.println("Someting wrong😑😑😑");
            }
        }
        again();
    }
    private static boolean masseging(List<Group> groupList) {
        int i=0;
        System.out.println("Groups: ");
        for (Group group1 : groupList) {
            System.out.println(i+1+". "+group1.getName());
        }
        Integer i1 = ScanUtil.intScan("Choose: ");
        i1--;
        Group group = groupList.get(i1);
        forGrupName(group);
        System.out.println("Write 0=> for exit");
        List<Massege> groupMassege = massegeService.getChatGroupMassege(group.getId());
        if (!groupMassege.isEmpty()){
            for (Massege massege : groupMassege) {
                if (!massege.getUserId().equals(FrontEnd.curUser.getId())){
                    System.out.println(Blue+massege.getText()+Reset);
                }else{
                    System.out.println("                                       "+Green+massege.getText()+Reset);
                }
            }
        }
        boolean check=true;
        while (check){
            String massege=FrontEnd.curUser.getName()+": ";
            String s = ScanUtil.strScan(FrontEnd.curUser.getUsername() + ": ");
            massege+=s;
            if (s.equals("0")) return true;
            massegeService.create(new Massege(group.getId(), FrontEnd.curUser.getId(), massege));
        }
        return true;
    }

    public static Integer menu(){
        System.out.println("""
                Groups Page:
                1.Show Group
                2.Show Only my Groups
                3.Create Group
                4.Leave Group
                0.Exit
                """);
        return ScanUtil.intScan("Choose: ");
    }
    public static Integer chooseMenu(){
        System.out.println("""
                1.Masseging to the group
                0.Back
                """);
        return ScanUtil.intScan("Choose: ");
    }
    public static Integer chooseMenu2(){
        System.out.println("""
                1.Join to the group
                0.Back
                """);
        return ScanUtil.intScan("Choose: ");
    }
    public static Integer chooseMenu3(){
        System.out.println("""
                1.Masseging Group
                2.Join to the groups
                0.Back
                """);
        return ScanUtil.intScan("Choose: ");
    }
    public static Integer menuForAdmin(){
        System.out.println("""
                1.Show All group members
                2.Add Users to my groups
                3.Upgrade Users to admin
                4.Delete Users from my group
                5.Update Group specialty
                6.DeleteGroup
                """);
        return ScanUtil.intScan("Choose: ");
    }
    public static void forGrupName(Group group){
        Integer i = chatGroupService.showHowUsersHave(group);
        System.out.println("===================================== "+group.getName()+"("+i+") =====================================");
    }
    public static void again(){
        System.out.println("===========================================================================================");
    }
}
