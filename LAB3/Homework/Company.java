package homework;

import java.util.HashMap;
import java.util.Map;

public class Company {
    private String name;
    private String office;
    private Map<String, Object> relationships = new HashMap<>();

    public Company(String name, String office) {
        this.name = name;
        this.office = office;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public void setRelationships(String key, Object object) {
        relationships.put(key, object);
    }
    public Map<String, Object> getRelationships() {
        return this.relationships;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", office='" + office + '\'' +
                '}';
    }
}
