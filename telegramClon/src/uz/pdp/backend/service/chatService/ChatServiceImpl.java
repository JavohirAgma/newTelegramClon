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

    static ChatService chatService;
    public static ChatService getInstance(){
        if (chatService==null){
            chatService = new ChatServiceImpl();
        }
        return chatService;
    }
}
