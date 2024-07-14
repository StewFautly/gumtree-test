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
                new Person("Bill McKnight", "Male"),
                new Person("Paul Robinson", "Male"),
                new Person("Gemma Lane", "Female"),
                new Person("Sarah Stone", "Female"),
                new Person("Wes Jackson", "Male")
        ));

        assertThat(peopleRepository.getPeople())
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

}
