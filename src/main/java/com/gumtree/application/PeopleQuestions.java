package com.gumtree.application;

import com.gumtree.domain.Gender;
import com.gumtree.domain.PeopleRepository;
import com.gumtree.domain.Person;

import java.util.stream.Collectors;

public class PeopleQuestions {

    private final PeopleRepository peopleRepository;

    public PeopleQuestions(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public Integer howMany(Gender gender) {
        return peopleRepository.getPeople().are(gender).size();
    }

    public String eldest() {
        return peopleRepository.getPeople().eldest().stream()
                .map(Person::name)
                .collect(Collectors.joining(","));
    }

}
