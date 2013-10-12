package model;

import java.util.Collection;

import javax.persistence.*;

@Entity
@NamedQuery(name="Project.findByName", query="SELECT p FROM Project p WHERE p.name = :name")
public class Project {

    @Id
    @Column(name = "projekti_id")
    @SequenceGenerator(name="my_seq", sequenceName="SEQ_1", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="my_seq")
    private Long id;

    public Project() {}

    public Project(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "projects")
    private Collection<Employee> employees;

    public Collection<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Collection<Employee> employees) {
        this.employees = employees;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        employee.getProjects().add(this);
    }
}
