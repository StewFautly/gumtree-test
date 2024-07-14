package com.gumtree.infrastructure;

import com.gumtree.domain.PeopleRepository;
import com.gumtree.domain.People;
import com.gumtree.domain.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CsvPeopleRepositoryTest {

    private PeopleRepository peopleRepository;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException {
        peopleRepository = new CsvPeopleRepository();
    }

    @Test
    void loadPeopleFromFile() {
        var expected = new People(List.of(
                new Person("Bill McKnight", "Male", "16/03/77"),
                new Person("Paul Robinson", "Male", "15/01/85"),
                new Person("Gemma Lane", "Female", "20/11/91"),
                new Person("Sarah Stone", "Female", "20/09/80"),
                new Person("Wes Jackson", "Male", "14/08/74")
        ));

        assertThat(peopleRepository.getPeople())
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

}
