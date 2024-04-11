package uz.pdp.backend.service.groupService;

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

    }

    @Override
    public void update(Group newM) {

    }

    @Override
    public void update(Group newM, String id) {

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
