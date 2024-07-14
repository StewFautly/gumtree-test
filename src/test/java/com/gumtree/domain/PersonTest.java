package com.gumtree.domain;

import org.junit.jupiter.api.Test;

import static com.gumtree.domain.Gender.FEMALE;
import static com.gumtree.domain.Gender.MALE;
import static org.assertj.core.api.Assertions.assertThat;

class PersonTest {

    private final Person bill = new Person("Bill McKnight", "Male");
    private final Person gemma = new Person("Gemma Lane", "Female");

    @Test
    void equals() {
        var expected = new Person("Bill McKnight", MALE);
        assertThat(bill)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

    @Test
    void isMale() {
        assertThat(bill.is(MALE)).isTrue();
    }

    @Test
    void isFemale() {
        assertThat(gemma.is(FEMALE)).isTrue();
    }


}