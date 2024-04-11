package uz.pdp.backend.model.group;

import uz.pdp.backend.enums.GroupRole;
import uz.pdp.backend.model.BaseModel;

public class Group extends BaseModel {
    private String name;
    private GroupRole role;

    public Group(String name, GroupRole role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GroupRole getRole() {
        return role;
    }

    public void setRole(GroupRole role) {
        this.role = role;
    }
}
