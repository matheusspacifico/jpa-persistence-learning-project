package br.edu.ifsp.matheuspacifico;

import br.edu.ifsp.matheuspacifico.model.Aluno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno();
        aluno1.setNome("Asdrubal da Silva");
        aluno1.setRa("1234567");
        aluno1.setEmail("asdrubal.silva@gmail.com");
        aluno1.setNota1(BigDecimal.valueOf(7.0));
        aluno1.setNota2(BigDecimal.valueOf(6.0));
        aluno1.setNota3(BigDecimal.valueOf(8.0));

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("avaliacao1prw3");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(aluno1);
        em.getTransaction().commit();

        em.close();
    }
}