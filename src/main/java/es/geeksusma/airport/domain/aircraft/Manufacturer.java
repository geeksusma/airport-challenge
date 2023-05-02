package es.geeksusma.airport.domain.aircraft;

public class Manufacturer {

    private final String code;

    private Manufacturer(String code) {
        this.code = code;
    }

    static Manufacturer of(String code) {
        return new Manufacturer(code);
    }

    String info() {
        return "Manufactured by: " + code;
    }
}
