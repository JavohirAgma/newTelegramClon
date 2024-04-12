package uz.pdp.backend.service.chatGroupService;

import uz.pdp.backend.enums.GroupRole;
import uz.pdp.backend.enums.UserRole;
import uz.pdp.backend.model.chatGroup.ChatGroup;
import uz.pdp.backend.model.group.Group;

import java.util.ArrayList;
import java.util.List;

public class ChatGroupServiceImpl implements ChatGroupService{
    List<ChatGroup> chatGroupList;

    public ChatGroupServiceImpl() {
        this.chatGroupList = new ArrayList<>();
    }

    @Override
    public boolean create(ChatGroup chatGroup) {
        boolean add = chatGroupList.add(chatGroup);
        return add;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(ChatGroup newM) {

    }

    @Override
    public void update(ChatGroup newM, String id) {

    }

    @Override
    public ChatGroup get(String id) {
        return null;
    }

    @Override
    public List<ChatGroup> getAll() {
        return null;
    }
    @Override
    public List<ChatGroup> getGroupList(String userId) {
        List<ChatGroup> chatGroups = new ArrayList<>();
        for (ChatGroup chatGroup : chatGroupList) {
            if (chatGroup.getUserID().equals(userId)){
                chatGroups.add(chatGroup);
            }
        }
        return chatGroups;
    }

    @Override
    public List<ChatGroup> getUsersList(String groupId) {
        List<ChatGroup> chatGroups = new ArrayList<>();
        for (ChatGroup chatGroup : chatGroupList) {
            if (chatGroup.getGroupId().equals(groupId)){
                chatGroups.add(chatGroup);
            }
        }
        return chatGroups;
    }

    @Override
    public Integer showHowUsersHave(Group group) {
        int res=0;
        for (ChatGroup chatGroup : chatGroupList) {
            if (chatGroup.getGroupId().equals(group.getId())){
                res++;
            }
        }
        return res;
    }

    @Override
    public boolean userToAdmin(String id) {
        for (ChatGroup chatGroup : chatGroupList) {
            if (chatGroup.getUserID().equals(id)){
                chatGroup.setRole(UserRole.ADMIN);
                return true;
            }
        }
        return false;
    }

    static ChatGroupService chatGroupService;
    public static ChatGroupService getInstance(){
        if (chatGroupService==null){
            chatGroupService = new ChatGroupServiceImpl();
        }
        return chatGroupService;
    }


}
