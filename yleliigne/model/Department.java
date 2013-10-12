package model;

import javax.persistence.*;

@Entity
@NamedQuery(name="Department.findByName", query="SELECT d FROM Department d WHERE d.name = :name")
public class Department extends AbstractEntity {

    public Department() {}

    public Department(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
