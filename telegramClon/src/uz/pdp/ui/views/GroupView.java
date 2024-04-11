package uz.pdp.ui.views;

import uz.pdp.backend.enums.GroupRole;
import uz.pdp.backend.enums.UserRole;
import uz.pdp.backend.model.chatGroup.ChatGroup;
import uz.pdp.backend.model.group.Group;
import uz.pdp.backend.service.chatGroupService.ChatGroupService;
import uz.pdp.backend.service.chatGroupService.ChatGroupServiceImpl;
import uz.pdp.backend.service.groupService.GroupService;
import uz.pdp.backend.service.groupService.GroupServiceImpl;
import uz.pdp.ui.FrontEnd;
import uz.pdp.ui.utils.ScanUtil;

import java.util.List;

public class GroupView {
    static GroupService groupService = GroupServiceImpl.getInstance();
    static ChatGroupService chatGroupService = ChatGroupServiceImpl.getInstance();
    public static void profile() {
        System.out.println("Welcome to Group Page");
        while (true){
            Integer menu = menu();
            switch (menu){
                case 1->MassegingGroup();
                case 2->CreateGroup();
                case 3->SearchGroup();
                case 4->DeleteGroup();
                case 0-> {
                    return;
                }
            }
        }
    }

    private static void MassegingGroup() {
        for (Group group : groupService.getAll()) {

        }


        /*List<ChatGroup> groupList = chatGroupService.getGroupList(FrontEnd.curUser.getId());
        for (ChatGroup chatGroup : groupList) {
            Group group = groupService.get(chatGroup.getGroupId());
            if (chatGroup.getRole().equals(UserRole.ADMIN)){
                System.out.println(group.getName()+"/My group");
            }else{
                System.out.println(group.getName());
            }
        }*/
    }

    private static void DeleteGroup() {

    }

    private static void SearchGroup() {

    }

    private static void CreateGroup() {
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
    }

    public static Integer menu(){
        System.out.println("""
                Groups Page:
                1.Massage With Group
                2.Create Group
                3.Search Group
                4.EditOwnGroups
                5.Go out of Group
                0.Exit
                """);
        return ScanUtil.intScan("Choose: ");
    }
}
