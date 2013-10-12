package model;

import java.util.List;

import javax.persistence.*;

@Entity
@NamedQueries({
    @NamedQuery(name="Person.findAll",
                query="SELECT p FROM Person p"),
    @NamedQuery(name="Person.findByName",
                query="SELECT p FROM Person p WHERE p.name = :name"),
})
public class Person extends AbstractEntity {

    private String name;

    @Transient
    private int age;

    @OneToMany(mappedBy = "person",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    private List<Address> addresses;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person: " + name;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
