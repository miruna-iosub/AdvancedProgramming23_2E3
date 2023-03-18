package bonus;

import java.time.LocalDate;

public class Bonus {
    public static void main(String[] args) {
        Network network = new Network();

        Designer alina = new Designer("Alina", LocalDate.of(1980, 1, 1), "UI/UX");
        Programmer santi = new Programmer("Santi", LocalDate.of(1985, 1, 1), "Java");

        Company topContaPlus = new Company("TopContaPlus", "Iasi");
        Company bnr = new Company("BNR", "Bucharest");

        santi.setRelationships("employer", topContaPlus);
        santi.setRelationships("employer", bnr);
        santi.setRelationships("friend", alina);
        topContaPlus.setRelationships("employee", santi);
        bnr.setRelationships("partner", topContaPlus);

        network.addNode(alina);
        network.addNode(santi);
        network.addNode(bnr);
        network.addNode(topContaPlus);

        // Check each node to see if there is a vertex that disconnects the network
        System.out.println("Checking if the network has disconnecting nodes: " + network.checkDisconnectingNode());
    }
}