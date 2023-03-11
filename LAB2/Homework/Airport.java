package homework;

class Airport extends Location {
    private int terminals;

    public Airport(String name, int terminals) {
        super(name);
        this.terminals = terminals;
    }

    public int getTerminals() {
        return terminals;
    }
}