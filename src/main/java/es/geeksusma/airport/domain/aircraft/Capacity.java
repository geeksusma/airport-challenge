package es.geeksusma.airport.domain.aircraft;

import java.util.Objects;

public class Capacity {

    private final Integer crew;
    private final Integer passengers;

    private Capacity(Integer crew, Integer passengers) {
        this.crew = crew;
        this.passengers = passengers;
    }

    public static Capacity of(Integer crew, Integer passengers) {
        if (crew < 4) {
            throw new IllegalCabinCrew("Not enough crew to drive a flight");
        }
        if (passengers < 20) {
            throw new NotEnoughPassengers("Not enough people aboard to proceed with a flight");
        }
        return new Capacity(crew, passengers);
    }

    static Capacity empty() {
        return new Capacity(0, 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Capacity capacity = (Capacity) o;
        return Objects.equals(crew, capacity.crew) && Objects.equals(passengers, capacity.passengers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(crew, passengers);
    }

    public Integer minCrew() {

        return this.crew;
    }

    public Integer minPassengers() {

        return this.passengers;
    }
}
