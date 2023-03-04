package compulsory;

public class Location {
    private String name;
    private LocationType type;
    private int population;
    private double latitudeN;
    private double longitudeE;

    public Location(String name, LocationType type, int population, double latitude, double longitude) {
        this.name = name;
        this.type = type;
        this.population = population;
        this.latitudeN = latitude;
        this.longitudeE = longitude;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setLatitude(double latitude) {
        this.latitudeN = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitudeE = longitude;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public double getLatitude() {
        return latitudeN;
    }

    public double getLongitude() {
        return longitudeE;
    }

    public LocationType getType() {
        return type;
    }

    public void setType(LocationType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Location{ " +
                "name='" + name + '\'' +
                ", type=" + type +
                ", population=" + population +
                ", latitude=" + latitudeN +
                ", longitude=" + longitudeE +
                '}';
    }
}