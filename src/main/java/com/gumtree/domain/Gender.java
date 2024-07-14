package com.gumtree.domain;

public enum Gender {
    MALE, FEMALE;

    static Gender from(String gender) {
        return Gender.valueOf(gender.toUpperCase());
    }

}
