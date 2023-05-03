package es.geeksusma.airport.domain.people;

import es.geeksusma.airport.domain.route.Tickets;

public class Passenger {

    private final Name name;

    private final LastName lastName;

    private final License passport;

    private final Birth birth;

    private final Tickets tickets;

    private Passenger(Name name, LastName lastName, License passport, Birth birth, Tickets tickets) {
        this.name = name;
        this.lastName = lastName;
        this.passport = passport;
        this.birth = birth;
        this.tickets = tickets;
    }
}
