package com.gumtree.application;

import com.gumtree.domain.People;
import com.gumtree.domain.PeopleRepository;
import com.gumtree.domain.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.gumtree.domain.Gender.FEMALE;
import static com.gumtree.domain.Gender.MALE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PeopleQuestionsTest {

    @InjectMocks
    private PeopleQuestions peopleQuestions;

    @Mock
    private PeopleRepository peopleRepository;

    private final People people = new People(List.of(
            new Person("Bill McKnight", "Male", "16/03/77"),
            new Person("Gemma Lane", "Female", "20/11/91"),
            new Person("Sarah Stone", "Female", "20/09/80")
    ));

    @BeforeEach
    void setUp() {
        when(peopleRepository.getPeople()).thenReturn(people);
    }

    @Test
    void howManyMales() {
        assertThat(peopleQuestions.howMany(MALE)).isEqualTo(1);
    }

    @Test
    void howManyFemales() {
        assertThat(peopleQuestions.howMany(FEMALE)).isEqualTo(2);
    }

    @Test
    void eldest() {
        assertThat(peopleQuestions.eldest()).isEqualTo("Bill McKnight");
    }

}
