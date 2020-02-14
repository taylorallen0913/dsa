// Skill.java
package cse41321.examples.lesson4.setCovering;

public class Skill {
    private String name;

    public Skill(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Skill))
            return false;

        Skill other = (Skill)o;

        return !(name != null ? !name.equals(other.name) : other.name != null);
    }
}
