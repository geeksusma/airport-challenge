package es.geeksusma.airport.domain.people;

public class Crew {

    private final Name name;

    private final LastName lastName;

    private final License flightLicense;

    private final Role role;

    private final Company employeer;

    private Crew(Name name, LastName lastName, License flightLicense, Role role, Company employeer) {
        this.name = name;
        this.lastName = lastName;
        this.flightLicense = flightLicense;
        this.role = role;
        this.employeer = employeer;
    }
}
