package compulsory;

import java.util.*; 
public class Compulsory {
    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Person("Cristina"));
        nodes.add(new Company("Google"));
        nodes.add(new Person("Ioana"));
        nodes.add(new Company("AMD"));
        Collections.sort(nodes, Comparator.comparing(Node::getName));
        for (Node node : nodes) {
            System.out.println(node.getName());
        }
    }
}
