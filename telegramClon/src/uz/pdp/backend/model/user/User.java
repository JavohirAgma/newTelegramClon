package uz.pdp.backend.model.user;

import uz.pdp.backend.model.BaseModel;

public class User extends BaseModel {
    private String username;
    private String name;
    private String password;

    public User(String name, String username, String password) {
        this.username = username;
        this.name = name;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return  username;
    }
}
