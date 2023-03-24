package bonus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.*;

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

    public List<List<Object>> identifyBlocks() {
        List<List<Object>> blocks = new ArrayList<>();
        Set<Object> visited = new HashSet<>();
        for (Object node : nodes) {
            if (!visited.contains(node)) {
                List<Object> block = new ArrayList<>();
                blocks.add(block);
                visit(node, visited, block);
            }
        }
        return blocks;
    }

    private void visit(Object node, Set<Object> visited, List<Object> block) {
        visited.add(node);
        block.add(node);
        List<Object> neighbors = getNeighbors(node);
        for (Object neighbor : neighbors) {
            if (!visited.contains(neighbor) && isTwoConnected(node, neighbor)) {
                visit(neighbor, visited, block);
            }
        }
    }

    private boolean isTwoConnected(Object node1, Object node2) {
        List<Object> neighbors1 = getNeighbors(node1);
        List<Object> neighbors2 = getNeighbors(node2);
        neighbors1.remove(node2);
        neighbors2.remove(node1);
        Set<Object> commonNeighbors = new HashSet<>(neighbors1);
        commonNeighbors.retainAll(neighbors2);
        return commonNeighbors.size() >= 1;
    }

    private List<Object> getNeighbors(Object node) {
        List<Object> neighbors = new ArrayList<>();
        if (node instanceof Person) {
            Map<String, Object> personsImportance = ((Person) node).getRelationships();
            for (Object neighbor : personsImportance.values()) {
                    neighbors.add(neighbor);
            }
        } else {
            Map<String, Object> companiesImportance = ((Company) node).getRelationships();
            for (Object neighbor : companiesImportance.values()) {
                    neighbors.add(neighbor);
            }
        }
        return neighbors;
    }
}
