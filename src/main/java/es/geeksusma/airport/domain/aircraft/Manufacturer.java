package es.geeksusma.airport.domain.aircraft;

import java.util.Objects;

public class Manufacturer {

    private final String code;

    private Manufacturer(String code) {
        this.code = code;
    }

    static Manufacturer of(String code) {
        return new Manufacturer(code);
    }

    public static Manufacturer empty() {
        return new Manufacturer("");
    }

    String info() {
        return "Manufactured by: " + code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manufacturer that = (Manufacturer) o;
        return Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
