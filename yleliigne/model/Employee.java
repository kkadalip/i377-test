package model;

import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name = "tootajad")
@NamedQuery(name="Employee.findByName", query="SELECT e FROM Employee e WHERE e.name = :name")
public class Employee {

    @Id
    @Column(name = "tootaja_id")
    @SequenceGenerator(name="my_seq", sequenceName="SEQ_1", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="my_seq")
    private Long id;

    @ManyToMany
    @JoinTable(
            name="tootaja_projekt",
            joinColumns={@JoinColumn(name="tootaja_id", referencedColumnName="tootaja_id")},
            inverseJoinColumns={@JoinColumn(name="projekti_id", referencedColumnName="projekti_id")})
    private Collection<Project> projects;

    @ManyToOne(optional = true)
    private Department department;

    public Collection<Project> getProjects() {
        return projects;
    }

    public void setProjects(Collection<Project> projects) {
        this.projects = projects;
    }

    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public Employee() {
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

}
