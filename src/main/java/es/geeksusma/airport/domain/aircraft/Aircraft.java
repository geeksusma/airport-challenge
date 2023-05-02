package es.geeksusma.airport.domain.aircraft;

public class Aircraft {
    private final Manufacturer manufacturer;
    private final Model model;
    private final Capacity capacity;

    private Aircraft(Manufacturer manufacturer, Model model, Capacity capacity) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.capacity = capacity;
    }

    public String info() {
        return manufacturer.info() + " " + model.info();
    }

    public Integer minCabinCrewSeats() {
        return capacity.minCrew();
    }

    public Integer minPassengerSeats() {
        return capacity.minPassengers();
    }

    public static class AircraftBuilder {
        private Manufacturer manufacturer;
        private Model model;
        private Capacity capacity;

        public static AircraftBuilder builder() {
            return new AircraftBuilder();
        }

        public AircraftBuilder withManufacturer(String manufacturer) {
            this.manufacturer = Manufacturer.of(manufacturer);
            return this;
        }

        public AircraftBuilder withModel(String model) {
            this.model = Model.of(model);
            return this;
        }

        public AircraftBuilder withCapacity(Integer crew, Integer passengers) {
            this.capacity = Capacity.of(crew, passengers);
            return this;
        }

        public Aircraft build() {
            return new Aircraft(this.manufacturer, this.model, this.capacity);
        }
    }
}