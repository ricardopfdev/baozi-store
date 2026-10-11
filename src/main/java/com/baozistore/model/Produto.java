package com.baozistore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

// @Entity diz ao Spring que essa classe representa uma tabela no banco de dados.
// @Table define o nome da tabela que sera criada no MySQL.
@Entity
@Table(name = "produtos")
public class Produto {

    // @Id marca o campo como chave primaria da tabela.
    // @GeneratedValue faz o banco gerar o ID automaticamente (auto incremento).
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private BigDecimal preco;

    private Boolean estoque;

    // Construtor vazio e obrigatorio para o JPA funcionar.
    public Produto() {
    }

    // Getters e Setters - servem para acessar e modificar os atributos da classe.

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

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Boolean getEstoque() {
        return estoque;
    }

    public void setEstoque(Boolean estoque) {
        this.estoque = estoque;
    }

}
