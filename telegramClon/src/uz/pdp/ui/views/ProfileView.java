package uz.pdp.ui.views;

import uz.pdp.backend.model.user.User;
import uz.pdp.backend.service.userService.UserService;
import uz.pdp.backend.service.userService.UserServiceImpl;
import uz.pdp.ui.FrontEnd;
import uz.pdp.ui.utils.ScanUtil;

public class ProfileView {
    static UserService userService = UserServiceImpl.getInstance();
    public static void profile() {
        System.out.println("Welcome to Profile Page");
        while (true){
            Integer menu = menu();
            switch (menu){
                case 1->EditInfo();
                case 0-> {
                    return;
                }
            }
        }
    }

    private static void EditInfo() {

    }

    private static void ShowInfo() {

    }

    public static Integer menu(){
        ShowInfo();
        System.out.println("""
                Profile:
                1.Edit Info
                0.Log Out
                """);
        return ScanUtil.intScan("Choose: ");
    }
}
