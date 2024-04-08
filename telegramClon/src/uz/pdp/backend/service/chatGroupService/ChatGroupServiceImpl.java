package uz.pdp.backend.service.chatGroupService;

import uz.pdp.backend.model.chatGroup.ChatGroup;

import java.util.ArrayList;
import java.util.List;

public class ChatGroupServiceImpl implements ChatGroupService{
    List<ChatGroup> chatGroupList;

    public ChatGroupServiceImpl() {
        this.chatGroupList = new ArrayList<>();
    }

    @Override
    public boolean create(ChatGroup chatGroup) {
        return false;
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

    static ChatGroupService chatGroupService;
    public static ChatGroupService getInstance(){
        if (chatGroupService==null){
            chatGroupService = new ChatGroupServiceImpl();
        }
        return chatGroupService;
    }
}
