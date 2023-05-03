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
                        .withCapacity(ManufacturerMotherObject.MIN_CREW_FOR_747, ManufacturerMotherObject.MAX_CREW_FOR_747, ManufacturerMotherObject.MIN_PASSENGERS_FOR_747, ManufacturerMotherObject.MAX_PASSENGERS_FOR_747)
                        .build()
        ).isNotNull()
                .satisfies(aircraft -> {
                    assertThat(aircraft.info()).isEqualTo("Manufactured by: " + ManufacturerMotherObject.MANUFACTURER_BOEING + " Model is: " + ManufacturerMotherObject.BOEING_747_MODEL);
                    assertThat(aircraft.minCabinCrewSeats()).isEqualTo(ManufacturerMotherObject.MIN_CREW_FOR_747);
                    assertThat(aircraft.minPassengerSeats()).isEqualTo(ManufacturerMotherObject.MIN_PASSENGERS_FOR_747);
                    assertThat(aircraft.maxCabinCrewSeats()).isEqualTo(ManufacturerMotherObject.MAX_CREW_FOR_747);
                    assertThat(aircraft.maxPassengerSeats()).isEqualTo(ManufacturerMotherObject.MAX_PASSENGERS_FOR_747);
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