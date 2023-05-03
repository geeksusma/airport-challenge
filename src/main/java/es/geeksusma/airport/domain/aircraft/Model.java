package es.geeksusma.airport.domain.aircraft;

import java.util.Objects;

public class Model {

    private final String code;

    private Model(String code) {
        this.code = code;
    }

    static Model of(String code) {
        return new Model(code);
    }

    static Model empty() {
        return new Model("");
    }

    String info() {
        return "Model is: " + code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model model = (Model) o;
        return Objects.equals(code, model.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
