package uz.pdp.backend.service.groupService;

import uz.pdp.backend.enums.GroupRole;
import uz.pdp.backend.model.chatGroup.ChatGroup;
import uz.pdp.backend.model.group.Group;

import java.util.ArrayList;
import java.util.List;

public class GroupServiceImpl implements GroupService{
    List<Group> groupList;

    public GroupServiceImpl() {
        this.groupList = new ArrayList<>();
    }

    @Override
    public boolean create(Group group) {
        boolean add = groupList.add(group);
        return add;
    }
    @Override
    public void delete(String id) {
        for (int i = 0; i < groupList.size(); i++) {
            if (groupList.get(i)!=null && groupList.get(i).getId().equals(id)){
                groupList.set(i,null);
            }
        }
    }

    @Override
    public void update(Group newM) {
    }

    @Override
    public void update(Group newM, String id) {
        for (int i = 0; i < groupList.size(); i++) {
            if (groupList.get(i).getId().equals(id)){
                groupList.set(i,newM);
            }
        }
    }

    @Override
    public Group get(String id) {
        for (Group group : groupList) {
            if (group.getId().equals(id)){
                return group;
            }
        }
        return null;
    }
    @Override
    public List<Group> getListById(List<ChatGroup> groupList) {
        List<Group> listOfGroup  = new ArrayList<>();
        for (ChatGroup chatGroup : groupList) {
            Group group = get(chatGroup.getGroupId());
            listOfGroup.add(group);
        }
        return listOfGroup;
    }

    @Override
    public List<Group> getListINotExist(List<ChatGroup> chatGroup) {
        List<Group> list = new ArrayList<>();
        for (int i = 0; i < groupList.size(); i++) {
            int res=0;
            for (int j = 0; j < chatGroup.size(); j++) {
                if (!groupList.get(i).getId().equals(chatGroup.get(j).getGroupId())){
                    res++;
                }
            }
            if (res==chatGroup.size()){
                list.add(groupList.get(i));
            }
        }
        return list;
    }

    @Override
    public void update(String id, String name, GroupRole role) {
        for (int i = 0; i < groupList.size(); i++) {
            if (groupList.get(i).getId().equals(id)){
                groupList.get(i).setName(name);
                groupList.get(i).setRole(role);
            }
        }
    }

    @Override
    public List<Group> getAll() {
        List<Group> groupList1 = new ArrayList<>();
        for (Group group : groupList) {
            if (group!=null){
                groupList1.add(group);
            }
        }
        return groupList1;
    }
    static GroupService groupService;
    public static GroupService getInstance(){
        if (groupService==null){
            groupService = new GroupServiceImpl();
        }
        return groupService;
    }



}
