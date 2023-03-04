package compulsory;
public class Road {
    private String name;
    private Location source;
    private Location destination;
    private RoadType type;
    private double length;

    public Road(String name, Location source, Location destination, RoadType type, double length) {
        this.name = name;
        this.source = source;
        this.destination = destination;
        this.type = type;
        this.length = length;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSource(Location source) {
        this.source = source;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public void setType(RoadType type) {
        this.type = type;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public Location getSource() {
        return source;
    }

    public Location getDestination() {
        return destination;
    }

    public RoadType getType() {
        return type;
    }

    public double getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "Road{ " +
                "name='" + name + '\'' +
                ", source=" + source +
                ", destination=" + destination +
                ", type=" + type +
                ", length=" + length +
                '}';
    }
}