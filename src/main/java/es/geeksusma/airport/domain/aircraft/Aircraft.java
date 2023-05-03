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

    public Integer maxCabinCrewSeats() {
        return capacity.maxCrew();
    }

    public Integer maxPassengerSeats() {
        return capacity.maxPassengers();
    }

    public static class AircraftBuilder {
        private Manufacturer manufacturer = Manufacturer.empty();
        private Model model = Model.empty();
        private Capacity capacity = Capacity.empty();

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

        public AircraftBuilder withCapacity(Integer minCrew, Integer maxCrew, Integer minPassengers, Integer maxPassengers) {
            this.capacity = Capacity.of(minCrew, maxCrew, minPassengers, maxPassengers);
            return this;
        }

        public Aircraft build() {
            if (Manufacturer.empty().equals(this.manufacturer)) {
                throw new NoManufacturer();
            }
            if (Model.empty().equals(this.model)) {
                throw new NoModel();
            }
            if (Capacity.empty().equals(this.capacity)) {
                throw new NoCapacity();
            }
            return new Aircraft(this.manufacturer, this.model, this.capacity);
        }
    }
}
