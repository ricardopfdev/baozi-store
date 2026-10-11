package com.baozistore.repository;

import com.baozistore.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

// O JpaRepository ja oferece os metodos prontos para salvar, buscar e deletar.
// Nao e necessario escrever nada aqui - o Spring Data JPA faz tudo automaticamente.
// Os metodos disponiveis sao: save(), findById(), findAll(), deleteById(), etc.
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
