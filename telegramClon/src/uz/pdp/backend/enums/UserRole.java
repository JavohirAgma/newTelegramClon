package uz.pdp.backend.enums;

import java.util.StringJoiner;

public enum UserRole {
    ADMIN,
    USER;
    public static String show() {
        StringJoiner joiner = new StringJoiner("\n");
        UserRole[] values = values();
        for (UserRole value : values) {
            joiner.add((value.ordinal()+1)+"."+value.name());
        }
        return joiner.toString();
    }
    public static UserRole getCategoryByOrdinal(Integer ordinal) {
        for (UserRole value : values()) {
            if (value.ordinal()==ordinal-1)
                return value;
        }
        return null;
    }
}

