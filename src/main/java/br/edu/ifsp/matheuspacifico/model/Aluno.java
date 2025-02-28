package br.edu.ifsp.matheuspacifico.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Table(name = "alunos")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String ra;
    private String email;
    private BigDecimal nota1;
    private BigDecimal nota2;
    private BigDecimal nota3;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getNota1() {
        return nota1;
    }

    public void setNota1(BigDecimal nota1) {
        this.nota1 = nota1;
    }

    public BigDecimal getNota2() {
        return nota2;
    }

    public void setNota2(BigDecimal nota2) {
        this.nota2 = nota2;
    }

    public BigDecimal getNota3() {
        return nota3;
    }

    public void setNota3(BigDecimal nota3) {
        this.nota3 = nota3;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Dados do aluno:\n");
        builder.append("Nome: ").append(nome).append("\n");
        builder.append("Email: ").append(email).append("\n");
        builder.append("Ra: ").append(ra).append("\n");
        builder.append("Notas: ").append(nota1).append("-").append(nota2).append("-").append(nota3).append("\n");
        return builder.toString();
    }

    public String getSituacao() {
        BigDecimal media = (nota1.add(nota2.add(nota3))).divide(BigDecimal.valueOf(3));

        if (media.compareTo(BigDecimal.valueOf(4)) < 0) {
            return "Reprovado";
        } else if (media.compareTo(BigDecimal.valueOf(4)) >=  0 && media.compareTo(BigDecimal.valueOf(6)) < 0) {
            return "Recuperação";
        }

        return "Aprovado";
    }
}
