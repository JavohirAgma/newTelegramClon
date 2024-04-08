package uz.pdp.ui.views;

import uz.pdp.ui.utils.ScanUtil;

public class UserView {
    public static void profile() {
        System.out.println("Welcome to User Profile");
        while (true){

        }
    }
    public static Integer menu(){
        System.out.println("""
                Login Telegram:
                1.Chat
                2.Group Works
                3.Go Profile
                0.Exit
                """);
        return ScanUtil.intScan("Choose: ");
    }
}
