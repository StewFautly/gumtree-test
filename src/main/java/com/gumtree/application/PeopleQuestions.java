package com.gumtree.application;

import com.gumtree.domain.Gender;
import com.gumtree.domain.PeopleRepository;

public class PeopleQuestions {

    private final PeopleRepository peopleRepository;

    public PeopleQuestions(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public Integer howMany(Gender gender) {
        return peopleRepository.getPeople().are(gender).size();
    }

}
