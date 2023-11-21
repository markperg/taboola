package com.example.calculator.module;

/**
 * Enum for handling and processing assigning types that can be supported
 */
public enum AssignmentType {
    SET("="),
    INCREMENT_AND_SET("+="),
    DECREMENT_AND_SET("-=");

    private String value;

    AssignmentType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    /**
     * Static method for converting String to enum
     * @param value
     * @return
     */
    public static AssignmentType fromString(String value) {
        for (AssignmentType type : AssignmentType.values()) {
            if (type.value.equals(value)) {
                return type;
            }
        }
        return null;
    }
}
