package compulsory;
public class Main {
    public static void main(String[] args){
        Location city1 = new Location("Iasi", LocationType.CITY, 319000, 47.1569, 27.5903);
        Location city2 = new Location("Bucharest", LocationType.CITY, 1800000, 44.4268 , 26.1025 );
        Location airport1 = new Location("Henri Coanda International Airport", LocationType.AIRPORT, 1000000, 44.5711 , 26.0858 );
        Location airport2 = new Location("Iasi International Airport", LocationType.AIRPORT, 14000000, 47.1747, 27.6178 );
        Road road1 = new Road("Latest Road", city1, city2, RoadType.HIGHWAY, 416);

        System.out.println(city1.toString());
        System.out.println(city2.toString());
        System.out.println(airport1.toString());
        System.out.println(airport2.toString());
        System.out.println(road1.toString());
    }
}
