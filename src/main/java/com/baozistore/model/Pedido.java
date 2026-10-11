package com.baozistore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// @Entity indica que essa classe representa uma tabela no banco de dados.
// @Table define o nome da tabela no MySQL.
@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Armazenamos apenas os IDs do cliente e do produto.
    // Essa e a forma mais simples de fazer a ligacao entre as tabelas,
    // sem precisar usar relacionamentos JPA como @ManyToOne.
    private Long clienteId;

    private Long produtoId;

    private Integer quantidade;

    // Construtor vazio obrigatorio para o JPA.
    public Pedido() {
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

}
