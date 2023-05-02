package es.geeksusma.airport.domain.aircraft;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class CapacityTest {

    @Test
    void should_throwWrongCapacity_when_crewIsLowerThanFour() {

        for (int crew = 3; crew > -2; crew--) {
            assertCabinCrew(crew);
        }
    }

    @Test
    void should_throwWrongCapacity_when_passengersIsLowerThan20() {

        for (int passengers = 19; passengers > -2; passengers--) {
            assertPassengers(passengers);
        }
    }

    @Test
    void should_createCapacity_when_enoughCrewAndPeople() {
        assertThat(Capacity.of(4, 20))
                .hasFieldOrPropertyWithValue("crew", 4)
                .hasFieldOrPropertyWithValue("passengers", 20);
    }

    private static void assertPassengers(final int passengers) {
        assertThat(catchThrowable(() -> Capacity.of(5, passengers)))
                .isInstanceOf(NotEnoughPassengers.class)
                .hasMessage("Not enough people aboard to proceed with a flight");
    }

    private static void assertCabinCrew(final int crew) {
        assertThat(catchThrowable(() -> Capacity.of(crew, null)))
                .isInstanceOf(IllegalCabinCrew.class)
                .hasMessage("Not enough crew to drive a flight");
    }
}