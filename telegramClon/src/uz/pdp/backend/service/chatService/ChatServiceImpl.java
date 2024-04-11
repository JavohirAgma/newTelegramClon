package uz.pdp.backend.service.chatService;

import uz.pdp.backend.model.chat.Chat;

import java.util.ArrayList;
import java.util.List;

public class ChatServiceImpl implements ChatService{
    List<Chat> chatList;

    public ChatServiceImpl() {
        this.chatList = new ArrayList<>();
    }

    @Override
    public boolean create(Chat chat) {
        boolean add = chatList.add(chat);
        return add;
    }

    @Override
    public void delete(String id) {
        for (int i = 0; i < chatList.size(); i++) {
            if (chatList.get(i)!=null && chatList.get(i).getId().equals(id)){
                chatList.set(i,null);
            }
        }
    }

    @Override
    public void update(Chat newM) {

    }

    @Override
    public void update(Chat newM, String id) {

    }

    @Override
    public Chat get(String id) {
        return null;
    }

    @Override
    public List<Chat> getAll() {
        List<Chat> existChats = new ArrayList<>();
        for (Chat chat : chatList) {
            if (chat!=null){
                existChats.add(chat);
            }
        }
        return null;
    }

    @Override
    public Chat isExist(String firstUserId, String secondUserId) {
            for (Chat chat : chatList) {
                if (chat!=null && (chat.getUserFirstId().equals(firstUserId) || chat.getUserFirstId().equals(secondUserId)
                        && chat.getUserSecondId().equals(firstUserId) || chat.getUserSecondId().equals(secondUserId))
                ){
                    return chat;
                }
            }
            return null;
    }

    @Override
    public Chat getChat(String fromUserId, String toUserId) {
        Chat chat = isExist(fromUserId, toUserId);
        return chat;
    }




    static ChatService chatService;
    public static ChatService getInstance(){
        if (chatService==null){
            chatService = new ChatServiceImpl();
        }
        return chatService;
    }
}
