package compulsory;

class Person implements Comparable<Person>, Node {
    private final String name; 

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Person other) {
        return name.compareTo(other.getName());
    }
}
