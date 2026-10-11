package com.baozistore.repository;

import com.baozistore.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

// Igual aos outros repositories, so que para a entidade Pedido.
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
