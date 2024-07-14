package com.gumtree.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.gumtree.domain.Gender.FEMALE;
import static com.gumtree.domain.Gender.MALE;
import static org.assertj.core.api.Assertions.assertThat;

class PeopleTest {

    private final People people = new People(List.of(
            new Person("Bill McKnight", "Male", "16/03/77"),
            new Person("Gemma Lane", "Female", "20/11/91"),
            new Person("Sarah Stone", "Female", "20/09/80")
    ));

    @Test
    void howManyAreMale() {
        assertThat(people.are(MALE))
                .hasSize(1);
    }

    @Test
    void howManyAreFemale() {
        assertThat(people.are(FEMALE))
                .hasSize(2);
    }

}
