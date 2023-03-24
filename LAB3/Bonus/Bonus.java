package bonus;

import java.time.LocalDate;
import java.util.*;
public class Bonus {
    public static void main(String[] args) {
        Network network = new Network();

        Programmer santi = new Programmer("Santi", LocalDate.of(1985, 1, 1), "Java");
        Designer alina = new Designer("Alina", LocalDate.of(1980, 1, 1), "UI/UX");

        Company topContaPlus = new Company("TopContaPlus", "Iasi");
        Company bnr = new Company("BNR", "Bucharest");
        Company opino = new Company("Opino", "Amsterdam");

        santi.setRelationships("employer", topContaPlus);
        topContaPlus.setRelationships("employer", santi);
        santi.setRelationships("partner", opino);
        opino.setRelationships("partner", bnr);
        alina.setRelationships("partner", bnr);

        topContaPlus.setRelationships("partner", bnr);
        santi.setRelationships("partner", bnr);

        bnr.setRelationships("partner", opino);
        alina.setRelationships("employer", opino);

        network.addNode(alina);
        network.addNode(santi);
        network.addNode(bnr);
        network.addNode(topContaPlus);
        network.addNode(opino);

        System.out.println("Checking if the network has disconnecting nodes: " + network.checkDisconnectingNode());
        System.out.println("The blocks of the network: ");

        List<List<Object>> blocks = network.identifyBlocks();
        for (List<Object> block : blocks) {
            System.out.println("Block:");
            for (Object node : block) {
                System.out.println(node);
            }
        }
    }
}
