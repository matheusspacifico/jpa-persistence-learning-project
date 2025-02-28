package br.edu.ifsp.matheuspacifico.dao;

import br.edu.ifsp.matheuspacifico.model.Aluno;
import jakarta.persistence.EntityManager;

import java.util.List;

public class AlunoDao {
    private final EntityManager em;

    public AlunoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Aluno aluno) {
        em.persist(aluno);
    }

    public void excluir(Aluno aluno) {
        em.remove(aluno);
    }

    public void alterar(Aluno aluno) {
        em.merge(aluno);
    }

    public Aluno buscarPorNome(String nome) {
        String jpql = "SELECT a FROM Aluno a WHERE a.nome = :n";
        return em.createQuery(jpql, Aluno.class).setParameter("n", nome).getResultList().get(0);
    }

    public List<Aluno> listarTodos() {
        String jpql = "SELECT a FROM Aluno a";
        return em.createQuery(jpql, Aluno.class).getResultList();
    }
}
