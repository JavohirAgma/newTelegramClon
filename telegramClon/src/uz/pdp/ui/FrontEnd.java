package uz.pdp.ui;

import uz.pdp.backend.model.user.User;
import uz.pdp.ui.views.LoginView;
import uz.pdp.ui.views.UserView;

import java.awt.*;
import java.sql.ResultSet;

public class FrontEnd {
    public static User curUser;
    public static void main(String[] args) {
        while (true){
            Integer menu = LoginView.menu();
            switch (menu){
                case 1->{
                    curUser = LoginView.logIn();
                    if (curUser!=null){
                        UserView.profile(curUser);
                    }else {
                        System.out.println("Your name or password incorrect❌❌❌");
                    }
                }
                case 2->LoginView.signUp();
                case 0->{
                    System.out.println("Bye Bye ");
                    return;
                }
            }
        }
    }
}
