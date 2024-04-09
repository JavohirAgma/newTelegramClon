package uz.pdp.ui.views;

import uz.pdp.backend.model.chat.Chat;
import uz.pdp.backend.model.user.User;
import uz.pdp.backend.service.chatService.ChatService;
import uz.pdp.backend.service.chatService.ChatServiceImpl;
import uz.pdp.backend.service.userService.UserService;
import uz.pdp.backend.service.userService.UserServiceImpl;
import uz.pdp.ui.utils.ScanUtil;

import java.util.List;

public class ChatView {
    static UserService userService = UserServiceImpl.getInstance();
    static ChatService chatService = ChatServiceImpl.getInstance();
    public static void profile(User curUser) {
        System.out.println("Welcome to Chatting Page");
        while (true){
            Integer menu = menu();
            switch (menu){
                case 1->MassegeChats(curUser);
                case 2->AddChat();
                case 3->SerchChat();
                case 4->ShowChats();
                case 5->DeleteChat();
                case 0-> {
                    return;
                }
            }
        }
    }

    private static void AddChat() {

    }

    private static void DeleteChat() {

    }

    private static void ShowChats() {

    }

    private static void SerchChat() {

    }

    private static void MassegeChats(User curUser) {
        int i=1;
        List<User> all = userService.getAll();
        for (User user : all) {
            if (user!=curUser){
                System.out.println((i++)+ ". " + user.getUsername());
            }
        }
        Integer index = ScanUtil.intScan("Choose: ");
        User chattingUser = all.get(index);
        System.out.println(chattingUser);
        boolean b = chatService.create(new Chat(chattingUser.getId(), curUser.getId()));
    }

    public static Integer menu(){
        System.out.println("""
                Chatting:
                1.Messiging Chats
                2.Add Chat
                3.Search Chat
                4.Show All Chats
                5.Delete Chat
                0.Exit
                """);
        return ScanUtil.intScan("Choose: ");
    }
}
