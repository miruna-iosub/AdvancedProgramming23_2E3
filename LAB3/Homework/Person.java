package homework;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Person {
    private String name;
    private LocalDate birthdate;
    private Map<String, Object> relationships = new HashMap<>();

    public Person(String name, LocalDate birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Map<String, Object> getRelationships() {
        return relationships;
    }

    public void setRelationships(String key, Object object) {
        relationships.put(key, object);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
