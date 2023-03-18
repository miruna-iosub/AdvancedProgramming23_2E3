package homework;

import java.time.LocalDate;

public class Homework {
    public static void main(String[] args) {
        Designer alina = new Designer("Alina", LocalDate.of(1987, 1, 1), "UI/UX");
        Programmer cristina = new Programmer("Santi", LocalDate.of(1985, 10, 1), "Java");

        Company topContaPlus = new Company("TopContaPlus", "Iasi");
        Company bnr = new Company("BNR", "Bucharest");

        cristina.setRelationships("employer", topContaPlus);
        cristina.setRelationships("employer", bnr);
        cristina.setRelationships("friend", alina);
        topContaPlus.setRelationships("employee", cristina);
        bnr.setRelationships("partner", topContaPlus);

        Network network = new Network();
        network.addNode(alina);
        network.addNode(cristina);
        network.addNode(bnr);
        network.addNode(topContaPlus);

        System.out.println("Info about the network: ");
        network.showNetwork();

        int importance = network.checkImportance(alina);
        System.out.println("Alina's importance in the network is: " + importance);

        int importance1 = network.checkImportance(bnr);
        System.out.println("BNR's importance in the network is: " + importance1);

        int importance2 = network.checkImportance(topContaPlus);
        System.out.println("TopContaPlus's importance in the network is: " + importance2);

        int importance3 = network.checkImportance(cristina);
        System.out.println("Cristina's importance in the network is: " + importance3);
    }
}