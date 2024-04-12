package uz.pdp.backend.service.chatGroupService;

import uz.pdp.backend.model.chatGroup.ChatGroup;
import uz.pdp.backend.model.group.Group;
import uz.pdp.backend.service.BaseService;

import java.util.List;

public interface ChatGroupService extends BaseService<ChatGroup> {
    List<ChatGroup> getGroupList(String userId);
    List<ChatGroup> getUsersList(String groupId);
    Integer showHowUsersHave(Group group);
    boolean userToAdmin(String id);
}
