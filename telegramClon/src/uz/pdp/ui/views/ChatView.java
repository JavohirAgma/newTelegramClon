package uz.pdp.ui.views;

import uz.pdp.backend.model.chat.Chat;
import uz.pdp.backend.model.massege.Massege;
import uz.pdp.backend.model.user.User;
import uz.pdp.backend.service.chatService.ChatService;
import uz.pdp.backend.service.chatService.ChatServiceImpl;
import uz.pdp.backend.service.massegeService.MassegeService;
import uz.pdp.backend.service.massegeService.MassegeServiceImpl;
import uz.pdp.backend.service.userService.UserService;
import uz.pdp.backend.service.userService.UserServiceImpl;
import uz.pdp.ui.utils.ScanUtil;

import java.util.Collections;
import java.util.List;

public class ChatView {
    static UserService userService = UserServiceImpl.getInstance();
    static ChatService chatService = ChatServiceImpl.getInstance();
    static MassegeService massegeService = MassegeServiceImpl.getInstance();
    final static String Blue = "\033[34m";
    final static String Green = "\u001b[32m";
    final static String Reset = "\033[0m";
    public static void profile(User curUser) {
        System.out.println("Welcome to Chatting Page");
        while (true){
            Integer menu = mainMenu();
            switch (menu){
                case 1->MassegeChats(curUser);
                case 2->SerchChat();
                case 3->ShowChats();
                case 4->DeleteChat();
                case 0-> {
                    return;
                }
            }
        }
    }


    private static void MassegeChats(User curUser) {
        User toUser = AddChat(curUser);
        masseging(toUser,curUser);
    }

    private static User AddChat(User curUser) {
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
        Chat exist = chatService.isExist(curUser.getId(), chattingUser.getId());
        if (exist==null){
            boolean b = chatService.create(new Chat(chattingUser.getId(), curUser.getId()));
        }
        return chattingUser;
    }
    public static boolean masseging(User toUser , User curUser){
        forUserName(toUser);
        System.out.println("Write 0=> for exit");
        Chat chat = chatService.getChat(curUser.getId(), toUser.getId());
        List<Massege> chatGroupMassege = massegeService.getChatGroupMassege(chat.getId());
        if (!chatGroupMassege.isEmpty()){
            String userId = chatGroupMassege.get(0).getUserId();
            for (Massege massege : chatGroupMassege) {
                if (massege.getUserId().equals(userId)){
                    System.out.println(Blue+massege.getText()+Reset);
                }else{
                    System.out.println("                                       "+Green+massege.getText()+Reset);
                }
            }
        }
        boolean check=true;
        while (check){
            String massege = curUser.getUsername()+": ";
            String s = ScanUtil.strScan(curUser.getUsername()+": ");
            massege+=s;
            if (s.equals("0")) return true;
            massegeService.create(new Massege(chat.getId(), curUser.getId(), massege));
        }
        return true;
    }

    private static void DeleteChat() {

    }

    private static void ShowChats() {

    }

    private static void SerchChat() {

    }

    public static Integer mainMenu(){
        System.out.println("""
                Chatting Page:
                1.Messiging Chats
                2.Search Chat
                3.Show All Chats  
                4.Delete Chat
                0.Exit
                """);
        return ScanUtil.intScan("Choose: ");
    }

    public static void forUserName(User masseginUser){
        System.out.println("===================================== "+masseginUser.getUsername()+" =====================================");
    }
}
