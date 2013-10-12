package dao;

import javax.persistence.*;

import model.Person;

public class PersonDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory(
            "my-hsql-unit");
    EntityManager em = emf.createEntityManager();

    public void save(Person person) {
        em.getTransaction().begin();

        if (person.getId() == null) {
            em.persist(person);
        } else {
            em.merge(person);
        }

        em.getTransaction().commit();
    }
}
