package com.guru.crud.entity;
       import java.util.HashMap;
        import java.util.Map;

public enum CategoryEnum {
    LITERATURE(0),
    NONFICTION(1),
    ACTION(2),
    THRILLER(3),
    TECHNOLOGY(4),
    DRAMA(5),
    POETRY(6),
    MEDIA(7),
    OTHERS(8);

    private int value;
    private static Map map = new HashMap<>();

    private CategoryEnum(int value) {
        this.value = value;
    }

    static {
        for (CategoryEnum category : CategoryEnum.values()) {
            map.put(category.value, category);
        }
    }

    public static CategoryEnum valueOf(int category) {
        return (CategoryEnum) map.get(category);
    }

    public int getValue() {
        return value;
    }
}