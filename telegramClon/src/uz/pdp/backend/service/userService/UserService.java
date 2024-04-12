package uz.pdp.backend.service.userService;

import uz.pdp.backend.dto.LoginDTO;
import uz.pdp.backend.model.chatGroup.ChatGroup;
import uz.pdp.backend.model.group.Group;
import uz.pdp.backend.model.user.User;
import uz.pdp.backend.service.BaseService;

import java.util.List;

public interface UserService extends BaseService<User> {
    User login(LoginDTO login);
    boolean userExist(User user);
    boolean updateWithItems(String id ,String name,String username,String password);
    List<User> addestUsers(ChatGroup mygroups);
    List<User> returnUser(List<ChatGroup> list);
    List<User> returnAll(List<ChatGroup> list);
    List<ChatGroup> returnForRole(List<ChatGroup> list);

}
