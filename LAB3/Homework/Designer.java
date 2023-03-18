package homework;

import java.time.LocalDate;

public class Designer extends Person {
    private String type;

    public Designer(String name, LocalDate birthdate, String type) {
        super(name, birthdate);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Designer{" + "name='" + getName() + "', " + "birthdate='" + getBirthdate() + "', " +
                "type='" + type + '\'' +
                '}';
    }
}
