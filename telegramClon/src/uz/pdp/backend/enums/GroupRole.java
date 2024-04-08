package uz.pdp.backend.enums;

import java.util.StringJoiner;

public enum GroupRole {
    PUBLIC,
    PRIVATE;
    public static String show() {
        StringJoiner joiner = new StringJoiner("\n");
        GroupRole[] values = values();
        for (GroupRole value : values) {
            joiner.add((value.ordinal()+1)+"."+value.name());
        }
        return joiner.toString();
    }
    public static GroupRole getCategoryByOrdinal(Integer ordinal) {
        for (GroupRole value : values()) {
            if (value.ordinal()==ordinal-1)
                return value;
        }
        return null;
    }
}
