package uz.pdp.backend.service.groupService;

import uz.pdp.backend.enums.GroupRole;
import uz.pdp.backend.model.chatGroup.ChatGroup;
import uz.pdp.backend.model.group.Group;
import uz.pdp.backend.service.BaseService;

import java.util.List;

public interface GroupService extends BaseService<Group> {
    List<Group> getListById(List<ChatGroup> chatGroup);
    List<Group> getListINotExist(List<ChatGroup> chatGroup);
    void update(String id, String name, GroupRole role);

}
