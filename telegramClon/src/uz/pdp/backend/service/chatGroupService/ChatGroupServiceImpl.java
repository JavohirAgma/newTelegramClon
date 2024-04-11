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
    public List<ChatGroup> getGroupList(String userId,Group group) {
        List<ChatGroup> chatGroups = new ArrayList<>();
        for (ChatGroup chatGroup : chatGroupList) {
            if (chatGroup.getUserID().equals(userId)){
                if (chatGroup.getRole().equals(UserRole.ADMIN)
                        || (chatGroup.getRole().equals(UserRole.USER) && group.getRole().equals(GroupRole.PUBLIC))
                ){
                    chatGroups.add(chatGroup);
                }else {

                }
            }
        }
        return chatGroups;
    }

    static ChatGroupService chatGroupService;
    public static ChatGroupService getInstance(){
        if (chatGroupService==null){
            chatGroupService = new ChatGroupServiceImpl();
        }
        return chatGroupService;
    }


}
