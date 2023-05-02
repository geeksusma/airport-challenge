package es.geeksusma.airport.domain.aircraft;

public class NotEnoughPassengers extends RuntimeException {
    public NotEnoughPassengers(String message) {
        super(message);
    }
}
