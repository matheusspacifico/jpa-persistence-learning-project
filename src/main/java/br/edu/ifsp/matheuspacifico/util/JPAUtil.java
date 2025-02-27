package br.edu.ifsp.matheuspacifico.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("avaliacao1prw3");

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }
}
