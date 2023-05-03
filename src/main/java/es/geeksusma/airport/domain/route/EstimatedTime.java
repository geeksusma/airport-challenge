package es.geeksusma.airport.domain.route;

import java.time.LocalDateTime;

public class EstimatedTime {

    private LocalDateTime clock;

    private EstimatedTime(LocalDateTime clock) {
        this.clock = clock;
    }

    static EstimatedTime of(LocalDateTime clock) {
        return new EstimatedTime(clock);
    }
}
