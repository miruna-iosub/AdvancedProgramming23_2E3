package homework;

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