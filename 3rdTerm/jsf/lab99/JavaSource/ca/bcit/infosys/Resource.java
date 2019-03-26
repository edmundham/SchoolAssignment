package ca.bcit.infosys;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Resource {

    private static EntityManagerFactory factory;

    @Produces
    public static EntityManager getEntityManager() {
        factory = Persistence.createEntityManagerFactory("lab99");
        EntityManager em = factory.createEntityManager();
        return em;
    }
}
