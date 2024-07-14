package com.gumtree.domain;

import com.gumtree.domain.exception.PersonNotFoundException;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public record People(List<Person> people) {

    private static final Comparator<Person> dateOfBirthComparator = Comparator.comparing(Person::dateOfBirth);

    public List<Person> are(Gender gender) {
        return people.stream()
                .filter(person -> person.is(gender))
                .collect(toList());
    }

    public List<Person> eldest() {
        Optional<LocalDate> eldestBirthday = people.stream()
                .min(dateOfBirthComparator)
                .map(Person::dateOfBirth);

        return eldestBirthday.map(birthday ->
                people.stream()
                        .filter(person -> birthday.equals(person.dateOfBirth()))
                        .toList()
        ).orElse(List.of());
    }

    public Person getPerson(String name) {
        return people.stream()
                .filter(person -> name.equals(person.name()))
                .findFirst()
                .orElseThrow(PersonNotFoundException::new);
    }

}
