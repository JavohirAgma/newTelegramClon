package uz.pdp.ui.views;

import uz.pdp.ui.utils.ScanUtil;

public class ChatView {
    public static void profile() {
        System.out.println("Welcome to Chatting Page");
        while (true){
            Integer menu = menu();
            switch (menu){
                case 1->AddChat();
                case 2->SerchChat();
                case 3->ShowChats();
                case 4->DeleteChat();
                case 0-> {
                    return;
                }
            }
        }
    }

    private static void DeleteChat() {

    }

    private static void ShowChats() {

    }

    private static void SerchChat() {

    }

    private static void AddChat() {

    }

    public static Integer menu(){
        System.out.println("""
                Chatting:
                1.Add Chat
                2.Search Chat
                3.Show All Chats
                4.Delete Chat
                0.Exit
                """);
        return ScanUtil.intScan("Choose: ");
    }
}
