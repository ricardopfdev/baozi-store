package com.baozistore.repository;

import com.baozistore.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

// Igual ao ProdutoRepository, so que para a entidade Cliente.
// O Spring Data JPA gera os metodos de banco automaticamente.
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
