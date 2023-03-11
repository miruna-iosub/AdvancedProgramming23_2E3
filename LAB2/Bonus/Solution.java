package bonus;

import java.util.*;

public class Solution {
    private final List<Location> locations = new ArrayList<>();
    private final List<Road> roads = new ArrayList<>();

    public void addLocation(Location location) {
        locations.add(location);
    }

    public void addRoad(Road road) {
        roads.add(road);
    }

    public List<Location> findShortestPath(Location start, Location end) {
        Map<Location, Integer> distances = new HashMap<>();
        Map<Location, Location> previousLocations = new HashMap<>();

        for (Location location : locations) {
            distances.put(location, Integer.MAX_VALUE);
            previousLocations.put(location, null);
        }

        distances.put(start, 0);

        Set<Location> unvisited = new HashSet<>(locations);

        while (!unvisited.isEmpty()) {
            // find the unvisited location with the smallest distance
            Location current = null;
            int smallestDistance = Integer.MAX_VALUE;

            for (Location location : unvisited) {
                int distance = distances.get(location);

                if (distance < smallestDistance) {
                    current = location;
                    smallestDistance = distance;
                }
            }

            if (current == end) {
                break;
            }

            unvisited.remove(current);

            // update the distances and previous locations for each neighbor of the current location that is being checked

            List<Road> neighbors = new ArrayList<>();
            // for each road that has a start point a certain location, add the whole road as a neighbor so checking distance can be possible
            for (Road road : roads) {
                if (road.getStart() == current) {
                    neighbors.add(road);
                }
            }

            for (Road road : neighbors) {
                Location neighbor = road.getEnd();
                int distanceToNeighbor = distances.get(current) + road.getDistance();

                if (distanceToNeighbor < distances.get(neighbor)) {
                    distances.put(neighbor, distanceToNeighbor);
                    previousLocations.put(neighbor, current);
                }
            }
        }

        // construct the path by following the previous locations from the destination to the source
        List<Location> path = new ArrayList<>();
        Location current = end;

        while (current != null) {
            path.add(current);
            current = previousLocations.get(current);
        }

        return path;
    }

    public List<Location> findFastestPath(Location start, Location end) {
        Map<Location, Double> durations = new HashMap<>();
        Map<Location, Location> previousLocations = new HashMap<>();

        for (Location location : locations) {
            durations.put(location, Double.POSITIVE_INFINITY);
            previousLocations.put(location, null);
        }

        durations.put(start, 0.0);

        Set<Location> unvisited = new HashSet<>(locations);

        while (!unvisited.isEmpty()) {
            // find the unvisited location with the smallest distance
            Location current = null;
            double smallestDuration = Double.POSITIVE_INFINITY;

            for (Location location : unvisited) {
                double duration = durations.get(location);

                if (duration < smallestDuration) {
                    current = location;
                    smallestDuration = duration;
                }
            }

            if (current == end) {
                break;
            }

            unvisited.remove(current);

            // update the distances and previous locations for each neighbor of the current location

            List<Road> neighbors = new ArrayList<>();
            // for each road that has a start point a certain location, add the whole road as a neighbor so checking its travel time can be possible
            for (Road road : roads) {
                if (road.getStart() == current) {
                    neighbors.add(road);
                }
            }

            for (Road road : neighbors) {
                Location neighbor = road.getEnd();
                double durationToNeighbor = durations.get(current) + road.getTravelTime();

                if (durationToNeighbor < durations.get(neighbor)) {
                    durations.put(neighbor, durationToNeighbor);
                    previousLocations.put(neighbor, current);
                }
            }
        }

        // construct the path by following the previous locations from the destination to the source
        List<Location> path = new ArrayList<>();
        Location current = end;

        while (current != null) {
            path.add(current);
            current = previousLocations.get(current);
        }

        return path;
    }
}
