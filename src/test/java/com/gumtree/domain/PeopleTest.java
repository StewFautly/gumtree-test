package com.gumtree.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.gumtree.domain.Gender.FEMALE;
import static com.gumtree.domain.Gender.MALE;
import static org.assertj.core.api.Assertions.assertThat;

class PeopleTest {

    private final People people = new People(List.of(
            new Person("Bill McKnight", "Male"),
            new Person("Gemma Lane", "Female"),
            new Person("Sarah Stone", "Female")
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
