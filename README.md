# Gumtree Technical Test

## Pre-requisites

Java 21

## Run tests

`./gradlew test`

## Run application

`./gradlew run`

## General Comments

1. Would normally use SLF4J rather than System out for the messages but didn't feel necessary here
2. The third task doesn't define how to handle if the 'older' person is actually younger so I'm returning 0 days older for that case (would likely depend on business requirements on how to handle this)
 