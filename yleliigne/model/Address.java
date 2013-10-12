package model;

import javax.persistence.*;

@Entity
public class Address extends AbstractEntity {

    private String street;

    @ManyToOne
    private Person person;

    public Address() {}

    public Address(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return street;
    }

}
