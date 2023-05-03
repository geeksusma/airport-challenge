package es.geeksusma.airport.domain.people;

public class Company {
    private final String code;
    private final Name name;

    private Company(String code, Name name) {
        this.code = code;
        this.name = name;
    }
}
