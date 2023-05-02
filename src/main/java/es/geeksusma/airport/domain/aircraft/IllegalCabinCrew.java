package es.geeksusma.airport.domain.aircraft;

public class IllegalCabinCrew extends RuntimeException {
    public IllegalCabinCrew(String message) {
        super(message);
    }
}
