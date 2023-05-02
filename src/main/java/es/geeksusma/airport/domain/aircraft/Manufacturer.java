package es.geeksusma.airport.domain.aircraft;

public class Manufacturer {

    private final String code;

    private Manufacturer(String code) {
        this.code = code;
    }

    public static Manufacturer of(String code) {
        return new Manufacturer(code);
    }
}
