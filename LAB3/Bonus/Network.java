package bonus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Network {
    private final List<Object> nodes;

    public Network() {
        this.nodes = new ArrayList<>();
    }

    public List<Object> getNodes() {
        return nodes;
    }

    public void addNode(Object node) {
        nodes.add(node);
    }

    public boolean checkDisconnectingNode() {
        List<Object> visitedNodes = new ArrayList<>();
        for (Object node : nodes) {
            if (!visitedNodes.contains(node)) {
                visitedNodes.add(node);
                int numConnectedNodes = checkTotalConnected(node, visitedNodes);
                if (numConnectedNodes != nodes.size()) {
                    return true;
                }
            }
        }
        return false;
    }

    private int checkTotalConnected(Object node, List<Object> visitedNodes) {
        int totalConnected = 1;
        if (node instanceof Person person) {
            Map<String, Object> relationships = person.getRelationships();
            for (Object relationship : relationships.values()) {
                if (!visitedNodes.contains(relationship)) {
                    visitedNodes.add(relationship);
                    totalConnected += checkTotalConnected(relationship, visitedNodes);
                }
            }
        } else if (node instanceof Company company) {
            Map<String, Object> relationships = company.getRelationships();
            for (Object relationship : relationships.values()) {
                if (!visitedNodes.contains(relationship)) {
                    visitedNodes.add(relationship);
                    totalConnected += checkTotalConnected(relationship, visitedNodes);
                }
            }
        }
        return totalConnected;
    }
}
