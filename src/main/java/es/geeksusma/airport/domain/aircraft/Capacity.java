package es.geeksusma.airport.domain.aircraft;

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
}
