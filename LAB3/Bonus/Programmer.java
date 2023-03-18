package bonus;

import java.time.LocalDate;

public class Programmer extends Person {
    private String skill;

    public Programmer(String name, LocalDate birthdate, String skill) {
        super(name, birthdate);
        this.skill = skill;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
