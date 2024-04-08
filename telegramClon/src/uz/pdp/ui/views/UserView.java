package uz.pdp.ui.views;

import uz.pdp.ui.utils.ScanUtil;

public class UserView {
    public static void profile() {
        System.out.println("Welcome to User Profile");
        while (true){
            Integer menu = menu();
            switch (menu){
                case 1->ChatView.profile();
                case 2->GroupView.profile();
                case 3->ProfileView.profile();
                case 0-> {
                    System.out.println("Bye Bye");
                    return;
                }
            }
        }
    }
    public static Integer menu(){
        System.out.println("""
                Main Page Telegram:
                1.Chat
                2.Group Works
                3.Go Profile
                0.Exit
                """);
        return ScanUtil.intScan("Choose: ");
    }
}
