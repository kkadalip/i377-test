package dao;

import javax.persistence.*;

import model.Unit;

public class UnitDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory(
            "my-hsql-unit");
    EntityManager em = emf.createEntityManager();

    public void save(Unit unit) {
        em.getTransaction().begin();

        if (unit.getId() == null) {
            em.persist(unit);
        } else {
            em.merge(unit);
        }

        em.getTransaction().commit();
    }
}
