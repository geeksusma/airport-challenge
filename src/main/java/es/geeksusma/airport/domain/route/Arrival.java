package es.geeksusma.airport.domain.route;

import es.geeksusma.airport.domain.Airport;

import java.time.LocalDateTime;

public class Arrival {

    private final Airport to;
    private final EstimatedTime estimatedAt;

    private Arrival(Airport to, EstimatedTime estimatedAt) {
        this.to = to;
        this.estimatedAt = estimatedAt;
    }

    static Arrival of(String code, LocalDateTime estimatedAt) {
        return new Arrival(Airport.of(code), EstimatedTime.of(estimatedAt));
    }
}
