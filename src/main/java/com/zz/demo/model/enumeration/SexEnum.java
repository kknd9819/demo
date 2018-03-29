package com.zz.demo.model.enumeration;

public enum SexEnum {
    MAN(1,"男"),
    WOMAN(2,"女");

    private int code;
    private String name;

    SexEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
