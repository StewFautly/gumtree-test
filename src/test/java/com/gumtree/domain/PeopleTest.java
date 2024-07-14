package com.gumtree.domain;

import com.gumtree.domain.exception.PersonNotFoundException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.gumtree.domain.Gender.FEMALE;
import static com.gumtree.domain.Gender.MALE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void eldest() {
        assertThat(people.eldest().stream().findFirst().map(Person::name))
                .hasValue("Bill McKnight");
    }

    @Test
    void eldestMultipleSameBirthday() {
        final People people = new People(List.of(
                new Person("Bill McKnight", "Male", "16/03/77"),
                new Person("Gemma Lane", "Female", "20/11/91"),
                new Person("Sarah Stone", "Female", "16/03/77")
        ));

        assertThat(people.eldest().stream().map(Person::name))
                .containsExactlyInAnyOrder("Bill McKnight", "Sarah Stone");
    }

    @Test
    void noEldest() {
        assertThat(new People(List.of()).eldest())
                .hasSize(0);
    }

    @Test
    void getPerson() {
        var expected = new Person("Gemma Lane", "Female", "20/11/91");

        assertThat(people.getPerson("Gemma Lane"))
                .isEqualTo(expected);
    }

    @Test
    void getMissingPerson() {
        assertThatThrownBy(() -> people.getPerson("Wes Jackson"))
                .isInstanceOf(PersonNotFoundException.class);
    }

}
