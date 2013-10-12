package example;

import java.util.*;

import javax.persistence.*;

import model.*;

import org.junit.Before;
import org.junit.Test;

public class Main {

    @Test
    public void insertPerson() throws Exception {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "my-hsql-unit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Person person = new Person("Jack");
        em.persist(person);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    @Test
    public void findPerson() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-hsql-unit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Person p = em.find(Person.class, 1L);
        System.out.println(p);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    @Test
    public void updatePerson() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-hsql-unit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Person person = em.find(Person.class, 1L);
        if (person != null) person.setName("Jill");

        tx.commit();
        em.close();
        emf.close();

        // select person0_.id as id1_1_0_, person0_.name as name2_1_0_
        //    from Person person0_ where person0_.id=?
        // update Person set name=? where id=?
    }

    @Test
    public void deletePerson() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-hsql-unit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Person person = em.find(Person.class, 1L);
        if (person != null) em.remove(person);

        tx.commit();
        em.close();
        emf.close();

        // select person0_.id as id0_0_, person0_.name as name0_0_
        //     from Person person0_ where person0_.id=?
        // delete from Person where id=?
    }

    @Test
    public void deleteAllAddresses() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-hsql-unit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Query query = em.createQuery("delete from Address");
        query.executeUpdate();

        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    @Test
    public void queryWithParameters() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-hsql-unit");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Person> query = em.createQuery(
                "select e from Person e where e.id = :id", Person.class);
        query.setParameter("id", 1L);
        Person person = query.getSingleResult();

        System.out.println(person);

        em.close();
        emf.close();
    }

    @Test
    public void namedQuery() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-hsql-unit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Person> namedQuery = em.createNamedQuery(
                "Person.findAll2", Person.class);
        List<Person> persons = namedQuery.getResultList();

        System.out.println(persons);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    @Test
    public void navigateManyToOne() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-hsql-unit");
        EntityManager em = emf.createEntityManager();

        Employee e = findByName(em, Employee.class, "emp1");
        Department department = e.getDepartment();

        System.out.println(department);

        em.close();
        emf.close();
    }

    @Test
    public void navigateOneToMany() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-hsql-unit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Person person = findByName(em, Person.class, "person1");
        System.out.println(person.getAddresses());

        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    @Test
    public void modifyCollection() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-hsql-unit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Person person = findByName(em, Person.class, "person1");
        List<Address> addresses = person.getAddresses();
        addresses.set(0, new Address("street 3"));

        person = findByName(em, Person.class, "person1");
        System.out.println(person.getAddresses());

        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    @Test
    public void addEmployeesToProjects() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-hsql-unit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Project project = findByName(em, Project.class, "proj1");
        Employee employee = findByName(em, Employee.class, "emp1");

        project.getEmployees().add(employee);
        employee.getProjects().add(project);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    private <T> T findByName(EntityManager em, Class<T> clazz, String name) {
        TypedQuery<T> query = em.createNamedQuery(
                clazz.getSimpleName() + ".findByName", clazz);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    @Before
    public void setUp() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-hsql-unit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.createNamedQuery("Admin.truncateTables").executeUpdate();
        em.createNamedQuery("Admin.resetSequence").executeUpdate();

        Person person = new Person("person1");
        em.persist(person);
        Address address1 = new Address("street 1");
        em.persist(address1);
        address1.setPerson(person);
        Address address2 = new Address("street 2");
        em.persist(address2);
        address2.setPerson(person);

        em.persist(new Project("proj1"));
        em.persist(new Project("proj2"));

        Employee employee = new Employee("emp1");
        em.persist(employee);
        em.persist(new Employee("emp2"));

        Department department = new Department("dep1");
        em.persist(department);
        employee.setDepartment(department);




        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}
