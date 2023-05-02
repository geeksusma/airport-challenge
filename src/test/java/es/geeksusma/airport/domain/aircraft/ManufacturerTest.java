package es.geeksusma.airport.domain.aircraft;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ManufacturerTest {

    public static final String MANUFACTURER_BOEING = "BOEING";

    @Test
    void should_createManufacturerWithCode_when_of() {

        assertThat(Manufacturer.of(MANUFACTURER_BOEING))
                .hasFieldOrPropertyWithValue("code", MANUFACTURER_BOEING);
    }
}