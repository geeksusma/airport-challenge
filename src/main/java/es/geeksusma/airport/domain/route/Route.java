package es.geeksusma.airport.domain.route;

import es.geeksusma.airport.domain.aircraft.Aircraft;

public class Route {

    private final Departure from;
    private final Arrival to;
    private final Aircraft aircraft;

    private Route(Departure from, Arrival to, Aircraft aircraft) {
        this.from = from;
        this.to = to;
        this.aircraft = aircraft;
    }

}
