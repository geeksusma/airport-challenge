package es.geeksusma.airport.domain.aircraft;

import java.util.Objects;

public class Capacity {

    private final Seats crew;
    private final Seats passengers;

    private Capacity(Seats crew, Seats passengers) {
        this.crew = crew;
        this.passengers = passengers;
    }

    public static Capacity of(Integer minCrew, Integer maxCrew, Integer minPassengers, Integer maxPassengers) {
        return new Capacity(Seats.of(maxCrew, minCrew), Seats.of(maxPassengers, minPassengers));
    }

    static Capacity empty() {
        return new Capacity(Seats.empty(), Seats.empty());
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

        return this.crew.min();
    }

    public Integer minPassengers() {

        return this.passengers.min();
    }

    public Integer maxCrew() {

        return this.crew.max();
    }

    public Integer maxPassengers() {

        return this.passengers.max();
    }
}
