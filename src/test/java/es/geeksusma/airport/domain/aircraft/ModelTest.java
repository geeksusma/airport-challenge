package es.geeksusma.airport.domain.aircraft;

import org.junit.jupiter.api.Test;

import static es.geeksusma.airport.data.ManufacturerMotherObject.BOEING_747_MODEL;
import static org.assertj.core.api.Assertions.assertThat;

class ModelTest {

    @Test
    void should_createModelWithCode_when_of() {

        assertThat(Model.of(BOEING_747_MODEL))
                .hasFieldOrPropertyWithValue("code", BOEING_747_MODEL);
    }
}