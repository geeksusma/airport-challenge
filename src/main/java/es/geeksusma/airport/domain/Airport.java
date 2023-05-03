package es.geeksusma.airport.domain;

public class Airport {
    private String code;

    private Airport(String code) {
        this.code = code;
    }

   public static Airport of(String code) {
        return new Airport(code);
    }
}
