package homework;

public class Homework {
    public static void main(String[] args) {
        ProblemInstance problem = new ProblemInstance();

        City bucharest = new City("Bucharest",  8336817);
        City iasi = new City("Iasi", 636857);
        Airport iasiAirport = new Airport("Iasi International Airport", 87534384);
        GasStation iasiGas = new GasStation("Iasi Gas Station", 6.50);

        problem.addLocation(bucharest);
        problem.addLocation(iasi);
        problem.addLocation(iasiGas);
        problem.addLocation(iasiAirport);

        Highway highway1 = new Highway(bucharest, iasi);
        Express express1 = new Express(bucharest, iasiAirport);
        Country country1 = new Country(bucharest, iasiGas);

        problem.addRoad(new Road(bucharest, iasi, highway1));
        problem.addRoad(new Road(bucharest, iasiAirport, country1));
        problem.addRoad(new Road(bucharest, iasiGas, express1));

        boolean canReach = problem.canReach(iasiGas, bucharest);
        System.out.println("Can reach Bucharest from IasiGas: " + canReach);
        System.out.println("Problem's instance is valid: " + problem.isValid());
    }
}