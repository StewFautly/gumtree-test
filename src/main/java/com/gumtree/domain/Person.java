package com.gumtree.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public record Person (String name, Gender gender, LocalDate dateOfBirth) {

    private static final DateTimeFormatter dateFormatter = new DateTimeFormatterBuilder()
            .appendPattern("dd/MM/")
            .appendValueReduced(ChronoField.YEAR, 2, 2, 1900)
            .toFormatter();

    private static LocalDate convertDateOfBirth(String dateOfBirth) {
        return LocalDate.parse(dateOfBirth, dateFormatter);
    }

    public Person(String name, String gender, String dateOfBirth) {
        this(name, Gender.from(gender), convertDateOfBirth(dateOfBirth));
    }

    public Boolean is(Gender gender) {
        return this.gender.equals(gender);
    }

    public long daysOlderThan(Person other) {
        // Technically someone younger is still 0 days older
        return dateOfBirth.isBefore(other.dateOfBirth) ?
                dateOfBirth.datesUntil(other.dateOfBirth).count() :
                0;
    }

}
