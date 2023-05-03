package es.geeksusma.airport.domain.aircraft;

import java.util.Objects;

public class Seats {

    private final Integer max;
    private final Integer min;

    private Seats(Integer max, Integer min) {
        this.max = max;
        this.min = min;
    }

    static Seats of(Integer max, Integer min) {
        return new Seats(max, min);
    }

    static Seats empty() {
        return new Seats(0, 0);
    }

    Integer min() {
        return min;
    }

    Integer max() {
        return max;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seats seats = (Seats) o;
        return Objects.equals(max, seats.max) && Objects.equals(min, seats.min);
    }

    @Override
    public int hashCode() {
        return Objects.hash(max, min);
    }
}
