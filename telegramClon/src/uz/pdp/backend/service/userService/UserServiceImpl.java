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
        boolean add = this.userList.add(user);
        return add;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(User newM) {

    }

    @Override
    public void update(User newM, String id) {

    }

    @Override
    public User get(String id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
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
