package compulsory;

class Company implements Comparable<Company>, Node {
    private final String name;

    public Company(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Company other) {
        return name.compareTo(other.getName());
    }
}
