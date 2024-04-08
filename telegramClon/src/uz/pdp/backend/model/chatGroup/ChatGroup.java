package uz.pdp.backend.model.chatGroup;

import uz.pdp.backend.enums.UserRole;
import uz.pdp.backend.model.BaseModel;

public class ChatGroup extends BaseModel {
    private String userID;
    private String groupId;
    private UserRole role;

    public ChatGroup(String userID, String groupId, UserRole role) {
        this.userID = userID;
        this.groupId = groupId;
        this.role = role;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
