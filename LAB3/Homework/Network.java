package homework;

import java.util.*;

public class Network {
    private List<Object> nodes;

    public Network() {
        this.nodes = new ArrayList<>();
    }

    public List<Object> getNodes() {
        return nodes;
    }

    public void addNode(Object node) {
        nodes.add(node);
    }

    public void showNetwork() {
        List<Object> sortedNodes = new ArrayList<>(nodes);
        Collections.sort(sortedNodes, Comparator.comparing(this::checkImportance));
        for (Object node : sortedNodes) {
            if (node instanceof Person person) {
                System.out.println(person.toString());
            } else if (node instanceof Company company) {
                System.out.println(company.toString());
            }
        }
    }

    public int checkImportance(Object node) {
        int importance = 0;
        if (node instanceof Person) {
            Map<String, Object> personsImportance = ((Person) node).getRelationships();
            importance = personsImportance.size();
        } else {
            Map<String, Object> companiesImportance = ((Company) node).getRelationships();
            importance = companiesImportance.size();
        }
        return importance;
    }
}
