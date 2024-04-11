package uz.pdp.backend.service.chatService;

import uz.pdp.backend.model.chat.Chat;
import uz.pdp.backend.service.BaseService;

public interface ChatService extends BaseService<Chat> {
    Chat isExist(String firstUserId , String secondUserId);
    Chat getChat(String fromUserId , String toUserId);
}
