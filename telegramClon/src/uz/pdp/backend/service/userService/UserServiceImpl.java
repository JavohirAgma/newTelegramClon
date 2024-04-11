package uz.pdp.backend.service.userService;

import uz.pdp.backend.dto.LoginDTO;
import uz.pdp.backend.model.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserServiceImpl implements UserService{
    List<User> userList;

    public UserServiceImpl() {
        this.userList = new ArrayList<>();
    }

    @Override
    public boolean create(User user) {
        boolean b = userExist(user);
        if (b){
            return false;
        }
        boolean add = this.userList.add(user);
        return add;
    }
    @Override
    public boolean userExist(User user) {
        for (User user1 : userList) {
            if (user.getPassword().equals(user1.getPassword()) && user.getUsername().equals(user1.getUsername())){
                return true;
            }
        }
        return false;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(User newM) {

    }

    @Override
    public void update(User newM, String id) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId().equals(id)){
                userList.set(i,newM);
            }
        }
    }

    @Override
    public User get(String id) {
        for (User user : userList) {
            if (user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        List<User> existUsers = new ArrayList<>();
        for (User user : userList) {
            if (user!=null){
                existUsers.add(user);
            }
        }
        return existUsers;
    }

    @Override
    public User login(LoginDTO login) {
        for (User user : userList) {
            if (Objects.equals(user.getUsername(),login.username())
                    && Objects.equals(user.getPassword(),login.password())){
                return user;
            }
        }
        return null;
    }


    static UserService userService;
    public static UserService getInstance() {
        if (userService==null){
            userService = new UserServiceImpl();
        }
        return userService;
    }
}
