package homework;

import java.util.*;

class ProblemInstance {
    private List<Location> locations;
    private List<Road> roads;

    public ProblemInstance() {
        this.locations = new ArrayList<>();
        this.roads = new ArrayList<>();
    }

    public boolean addLocation(Location location) {
        if (locations.contains(location)) {
            return false;
        }
        locations.add(location);
        return true;
    }

    public boolean addRoad(Road road) {
        if (roads.contains(road)) {
            return false;
        }
        if (!locations.contains(road.getStart()) || !locations.contains(road.getEnd())) {
            return false;
        }
        roads.add(road);
        return true;
    }

    public boolean isValid() {
        for (Location location : locations) {
            boolean visited = false;
            for (Road road : roads) {
                if (road.getStart().equals(location) || road.getEnd().equals(location)) {
                    visited = true;
                    break;
                }
            }
            if (!visited) {
                return false;
            }
        }
        return true;
    }

    public boolean canReach(Location start, Location end) {
        // bfs
        List<Location> visited = new ArrayList<>();
        List<Location> unvisited = new ArrayList<>();
        unvisited.add(start);
        while (!unvisited.isEmpty()) {
            Location location = unvisited.remove(0);
            visited.add(location);
            if (location.equals(end)) {
                return true;
            }
            for (Road road : roads) {
                if (road.getStart().equals(location) && !visited.contains(road.getEnd()) && !unvisited.contains(road.getEnd())) {
                    unvisited.add(road.getEnd());
                } else if (road.getEnd().equals(location) && !visited.contains(road.getStart()) && !unvisited.contains(road.getStart())) {
                    unvisited.add(road.getStart());
                }
            }
        }
        return false;
    }
}