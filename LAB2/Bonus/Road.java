package bonus;

import java.util.Objects;

class Road {
    private final Location start;
    private final Location end;
    private int distance;
    private int speedLimit;

    public Road(Location start, Location end, int distance, int speedLimit) {
        this.start = start;
        this.end = end;
        this.distance = distance;
        this.speedLimit = speedLimit;
    }

    public Location getStart() {
        return start;
    }

    public Location getEnd() {
        return end;
    }

    public void setDistance(int distance){ this.distance = distance;}

    public int getDistance() {
        return distance;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public double getTravelTime() {
        return distance / speedLimit;
    }


    @Override
    public String toString() {
        return "Road{" + "start=" + start + ", end=" + end + ", distance=" + distance + ", speedLimit=" + speedLimit + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Road road = (Road) o;
        return distance == road.distance && speedLimit == road.speedLimit && Objects.equals(start, road.start) && Objects.equals(end, road.end);
    }
}