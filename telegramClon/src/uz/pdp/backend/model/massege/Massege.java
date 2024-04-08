package uz.pdp.backend.model.massege;

import uz.pdp.backend.model.BaseModel;

public class Massege extends BaseModel {
    private String idOfChatOrGroup;
    private String userId;
    private String text;

    public Massege(String idOfChatOrGroup, String userId, String text) {
        this.idOfChatOrGroup = idOfChatOrGroup;
        this.userId = userId;
        this.text = text;
    }

    public String getIdOfChatOrGroup() {
        return idOfChatOrGroup;
    }

    public void setIdOfChatOrGroup(String idOfChatOrGroup) {
        this.idOfChatOrGroup = idOfChatOrGroup;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
