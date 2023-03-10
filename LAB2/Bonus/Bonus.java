package bonus;

import java.util.List;

public class Bonus {
    public static void main(String[] args) {
        Location iasi = new Location("Iasi");
        Location bucharest = new Location("Bucharest");
        Location cluj = new Location("Cluj");
        Location timisoara = new Location("Timisoara");

        Road road1 = new Road(iasi, bucharest, 455, 100000);
        Road road2 = new Road(iasi, cluj, 442, 100);
        Road road3 = new Road(bucharest, timisoara, 547, 100);
        Road road4 = new Road(cluj, timisoara, 314, 100);

        Solution solution = new Solution();

        solution.addLocation(iasi);
        solution.addLocation(bucharest);
        solution.addLocation(cluj);
        solution.addLocation(timisoara);

        solution.addRoad(road1);
        solution.addRoad(road2);
        solution.addRoad(road3);
        solution.addRoad(road4);

        List<Location> shortestPath = solution.findShortestPath(iasi, timisoara);
        List<Location> fastestPath = solution.findFastestPath(iasi, timisoara);

        System.out.println("Shortest path between " + iasi.getName() + " and " + timisoara.getName() + ": " + shortestPath.toString());
        System.out.println("Fastest path between " + iasi.getName() + " and " + timisoara.getName() + ": " + fastestPath.toString());
    }
}
