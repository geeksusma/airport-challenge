package es.geeksusma.airport.domain.route;

import es.geeksusma.airport.domain.Airport;

import java.time.LocalDateTime;

public class Departure {

    private final Airport from;
    private final EstimatedTime scheduledAt;

    private Departure(Airport from, EstimatedTime scheduledAt) {
        this.from = from;
        this.scheduledAt = scheduledAt;
    }

    static Departure of(String code, LocalDateTime at) {
        return new Departure(Airport.of(code), EstimatedTime.of(at));
    }
}
