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
        String name = ScanUtil.strScan("Enter new/old name: ");
        String username = ScanUtil.strScan("Enter new/old username: ");
        String password = ScanUtil.strScan("Enter new/old password: ");
        boolean b = userService.updateWithItems(FrontEnd.curUser.getId(), name, username, password);
        if (b){
            System.out.println("Muvaffaqiyatli amalga oshdi");
        }else{
            System.out.println("Xato boldi");
        }
        System.out.println();
    }

    private static void ShowInfo() {
        User user = FrontEnd.curUser;
        System.out.println("Your name: "+user.getName());
        System.out.println("Your username: "+user.getUsername());
        System.out.println("Your password: "+user.getPassword());
        System.out.println();
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
