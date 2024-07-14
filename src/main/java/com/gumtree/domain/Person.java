package com.gumtree.domain;

public record Person (String name, Gender gender) {

    public Person(String name, String gender) {
        this(name, Gender.from(gender));
    }

    public Boolean is(Gender gender) {
        return this.gender.equals(gender);
    }

}
