package es.geeksusma.airport.domain.aircraft;

import es.geeksusma.airport.data.ManufacturerMotherObject;
import org.junit.jupiter.api.Test;

import static es.geeksusma.airport.domain.aircraft.Aircraft.AircraftBuilder;
import static org.assertj.core.api.Assertions.assertThat;

class AircraftTest {

    @Test
    void should_createAircraft_when_hasManufacturerModelAndCapacity() {

        assertThat(
                AircraftBuilder.builder()
                        .withManufacturer(ManufacturerMotherObject.MANUFACTURER_BOEING)
                        .withModel(ManufacturerMotherObject.BOEING_747_MODEL)
                        .withCapacity(4, 20)
                        .build()
        ).isNotNull()
                .satisfies(aircraft -> {
                    assertThat(aircraft.info()).isEqualTo("Manufactured by: " + ManufacturerMotherObject.MANUFACTURER_BOEING + " Model is: " + ManufacturerMotherObject.BOEING_747_MODEL);
                    assertThat(aircraft.minCabinCrewSeats()).isEqualTo(4);
                    assertThat(aircraft.minPassengerSeats()).isEqualTo(20);
                });
    }
}