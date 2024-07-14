package com.gumtree.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static com.gumtree.domain.Gender.FEMALE;
import static com.gumtree.domain.Gender.MALE;
import static org.assertj.core.api.Assertions.assertThat;

class PersonTest {

    private final Person bill = new Person("Bill McKnight", "Male", "16/03/77");
    private final Person gemma = new Person("Gemma Lane", "Female", "20/11/91");

    @Test
    void equals() {
        var expected = new Person("Bill McKnight", MALE, LocalDate.of(1977, 3, 16));
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

    @Test
    void howManyDaysOlderThan() {
        assertThat(bill.daysOlderThan(gemma)).isEqualTo(5362);
    }

    @Test
    void howManyDaysOlderWhenSameBirthday() {
        assertThat(bill.daysOlderThan(bill)).isEqualTo(0);
    }

    @Test
    void howManyDaysOlderWhenYounger() {
        assertThat(gemma.daysOlderThan(bill)).isEqualTo(0);
    }

}
