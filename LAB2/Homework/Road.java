package homework;

import java.util.Objects;

public class Road {
    private Location start;
    private Location end;
    private Highway highway;
    private Express express;
    private Country country;

    public Road(Location start, Location end) {
        this.start = start;
        this.end = end;
    }

    public Road(Location start, Location end, Highway highway) {
        this.start = start;
        this.end = end;
        this.highway = highway;
    }

    public Road(Location start, Location end, Express express) {
        this.start = start;
        this.end = end;
        this.express = express;
    }

    public Road(Location start, Location end, Country country) {
        this.start = start;
        this.end = end;
        this.country = country;
    }

    public Location getStart() {
        return start;
    }

    public void setStart(Location start) {
        this.start = start;
    }

    public Location getEnd() {
        return end;
    }

    public void setEnd(Location end) {
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Road road = (Road) o;
        return Objects.equals(start, road.start) && Objects.equals(end, road.end);
    }
}
