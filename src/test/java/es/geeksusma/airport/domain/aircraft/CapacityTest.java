package es.geeksusma.airport.domain.aircraft;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CapacityTest {

    @Test
    void should_createCapacity_when_crewAndPeople() {
        assertThat(Capacity.of(4, 8, 20, 200))
                .hasFieldOrPropertyWithValue("crew", Seats.of(8, 4))
                .hasFieldOrPropertyWithValue("passengers", Seats.of(200, 20));
    }
}