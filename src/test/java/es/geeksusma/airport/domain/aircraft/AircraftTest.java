package es.geeksusma.airport.domain.aircraft;

import es.geeksusma.airport.data.ManufacturerMotherObject;
import org.junit.jupiter.api.Test;

import static es.geeksusma.airport.domain.aircraft.Aircraft.AircraftBuilder;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

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

    @Test
    void should_throwNoManufacturer_when_build() {
        assertThat(catchThrowable(() ->
                AircraftBuilder.builder().build())
        ).isInstanceOf(NoManufacturer.class);
    }

    @Test
    void should_throwNoModel_when_build() {
        assertThat(catchThrowable(() ->
                AircraftBuilder.builder()
                        .withManufacturer(ManufacturerMotherObject.MANUFACTURER_BOEING)
                        .build())
        ).isInstanceOf(NoModel.class);
    }

    @Test
    void should_throwNoCapacity_when_build() {
        assertThat(catchThrowable(() ->
                AircraftBuilder.builder()
                        .withManufacturer(ManufacturerMotherObject.MANUFACTURER_BOEING)
                        .withModel(ManufacturerMotherObject.BOEING_747_MODEL)
                        .build())
        ).isInstanceOf(NoCapacity.class);
    }
}