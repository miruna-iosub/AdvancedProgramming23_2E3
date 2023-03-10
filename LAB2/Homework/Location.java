package homework;

import java.util.Objects;

public class Location {
    String name;

    public Location(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(name, location.name);
    }
}

class City extends Location {
    private int population;

    public City(String name, int population) {
        super(name);
        this.population = population;
    }

    public int getPopulation() {
        return population;
    }
}

class Airport extends Location {
    private int terminals;

    public Airport(String name, int terminals) {
        super(name);
        this.terminals = terminals;
    }

    public int getTerminals() {
        return terminals;
    }
}

class GasStation extends Location {
    private double gasPrice;

    public GasStation(String name, double gasPrice) {
        super(name);
        this.gasPrice = gasPrice;
    }

    public double getGasPrice() {
        return gasPrice;
    }
}