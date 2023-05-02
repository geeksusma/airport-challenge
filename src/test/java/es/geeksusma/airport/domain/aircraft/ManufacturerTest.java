package es.geeksusma.airport.domain.aircraft;

import org.junit.jupiter.api.Test;

import static es.geeksusma.airport.data.ManufacturerMotherObject.MANUFACTURER_BOEING;
import static org.assertj.core.api.Assertions.*;

class ManufacturerTest {

    @Test
    void should_createManufacturerWithCode_when_of() {

        assertThat(Manufacturer.of(MANUFACTURER_BOEING))
                .hasFieldOrPropertyWithValue("code", MANUFACTURER_BOEING);
    }
}