package es.geeksusma.airport.domain.route;

public class Ticket {
    private final Departure from;

    private final Arrival to;

    private Ticket(Departure from, Arrival to) {
        this.from = from;
        this.to = to;
    }

}
