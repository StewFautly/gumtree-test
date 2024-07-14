package com.gumtree.infrastructure;

import com.gumtree.domain.PeopleRepository;
import com.gumtree.domain.People;
import com.gumtree.domain.Person;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.util.Arrays.asList;

public class CsvPeopleRepository implements PeopleRepository {

    private final People people;

    public CsvPeopleRepository() throws IOException, URISyntaxException {
        people = new People(Files.readAllLines(Paths.get(ClassLoader.getSystemResource("AddressBook").toURI()))
                .stream()
                .map(line -> asList(line.split(",")))
                .map(p -> new Person(
                        p.getFirst().trim(),
                        p.get(1).trim(),
                        p.getLast().trim()
                ))
                .toList()
        );
    }

    @Override
    public People getPeople() {
        return people;
    }

}
