package uz.pdp.ui.views;

import uz.pdp.ui.FrontEnd;
import uz.pdp.ui.utils.ScanUtil;

public class ProfileView {
    public static void profile() {
        System.out.println("Welcome to Profile Page");
        while (true){
            Integer menu = menu();
            switch (menu){
                case 1->ShowInfo();
                case 2->EditInfo();
                case 3-> LoginView.menu();
            }
        }
    }

    private static void EditInfo() {

    }

    private static void ShowInfo() {

    }

    public static Integer menu(){
        System.out.println("""
                Profile:
                1.Show Info
                2.Edit Info
                0.Log Out
                """);
        return ScanUtil.intScan("Choose: ");
    }
}
