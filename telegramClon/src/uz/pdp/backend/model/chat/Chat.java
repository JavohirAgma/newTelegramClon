package uz.pdp.backend.model.chat;

import uz.pdp.backend.model.BaseModel;

public class Chat extends BaseModel {
    private String userFirstId;
    private String userSecondId;

    public Chat(String userFirstId, String userSecondId) {
        this.userFirstId = userFirstId;
        this.userSecondId = userSecondId;
    }

    public String getUserFirstId() {
        return userFirstId;
    }

    public void setUserFirstId(String userFirstId) {
        this.userFirstId = userFirstId;
    }

    public String getUserSecondId() {
        return userSecondId;
    }

    public void setUserSecondId(String userSecondId) {
        this.userSecondId = userSecondId;
    }
}
