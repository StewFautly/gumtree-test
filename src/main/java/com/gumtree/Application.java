package com.gumtree;

import com.gumtree.application.PeopleQuestions;
import com.gumtree.domain.PeopleRepository;
import com.gumtree.infrastructure.CsvPeopleRepository;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.gumtree.domain.Gender.MALE;

public class Application {

    public static void main(String[] args) throws IOException, URISyntaxException {
        PeopleRepository peopleRepository = new CsvPeopleRepository();
        PeopleQuestions peopleQuestions = new PeopleQuestions(peopleRepository);

        // Question 1
        System.out.println("There are " + peopleQuestions.howMany(MALE) + " males");
    }

}
