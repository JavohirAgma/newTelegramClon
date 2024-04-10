package uz.pdp.ui.views;

import uz.pdp.backend.dto.LoginDTO;
import uz.pdp.backend.enums.UserRole;
import uz.pdp.backend.model.user.User;
import uz.pdp.backend.service.userService.UserService;
import uz.pdp.backend.service.userService.UserServiceImpl;
import uz.pdp.ui.utils.ScanUtil;

public class LoginView {
    static UserService userService = UserServiceImpl.getInstance();
    public static User logIn(){
        System.out.println("Enter Login Info");
        String username = ScanUtil.strScan("username: ");
        String password = ScanUtil.strScan("password: ");
        User login = userService.login(new LoginDTO(username, password));
        return login;
    }
    public static void signUp(){
        System.out.println("Enter Login info");
        String name = ScanUtil.strScan("real name: ");
        String username = ScanUtil.strScan("username: ");
        String password = ScanUtil.strScan("password: ");
        boolean b = userService.create(new User(name, username, password));
        if (b){
            System.out.println("Create succesfully🎉🎉🎉");
        }else{
            System.out.println("You can't create user // username and password is exist");
        }
    }
    public static Integer menu(){
        System.out.println("""
                Login Telegram:
                1.Log In
                2.Sign Up
                0.Exit
                """);
        return ScanUtil.intScan("Choose: ");
    }
}
