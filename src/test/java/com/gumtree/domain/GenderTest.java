package com.gumtree.domain;

import org.junit.jupiter.api.Test;

import static com.gumtree.domain.Gender.FEMALE;
import static com.gumtree.domain.Gender.MALE;
import static org.assertj.core.api.Assertions.assertThat;

class GenderTest {

    @Test
    void fromMale() {
        var male = "Male";
        assertThat(Gender.from(male)).isEqualTo(MALE);
    }

    @Test
    void fromFemale() {
        var female = "Female";
        assertThat(Gender.from(female)).isEqualTo(FEMALE);
    }

}
