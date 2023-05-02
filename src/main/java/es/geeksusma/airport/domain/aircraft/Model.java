package es.geeksusma.airport.domain.aircraft;

public class Model {

    private final String code;

    private Model(String code) {
        this.code = code;
    }

    static Model of(String code) {
        return new Model(code);
    }

    String info() {
        return "Model is: " + code;
    }
}
