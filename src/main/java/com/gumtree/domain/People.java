package com.gumtree.domain;

import java.util.List;

import static java.util.stream.Collectors.toList;

public record People(List<Person> people) {

    public List<Person> are(Gender gender) {
        return people.stream()
                .filter(person -> person.is(gender))
                .collect(toList());
    }

}
