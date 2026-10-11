package com.baozistore.controller;

import com.baozistore.model.Pedido;
import com.baozistore.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

// @RestController indica que essa classe e um controller REST.
// @RequestMapping define o caminho base dos endpoints de pedido.
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    // POST /pedidos - registra um novo pedido
    @PostMapping
    public Pedido cadastrar(@RequestBody Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    // GET /pedidos - lista todos os pedidos
    @GetMapping
    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    // GET /pedidos/{id} - busca um pedido pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);

        if (pedido.isPresent()) {
            return ResponseEntity.ok(pedido.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // PUT /pedidos/{id} - atualiza um pedido existente
    @PutMapping("/{id}")
    public ResponseEntity<Pedido> atualizar(@PathVariable Long id, @RequestBody Pedido pedidoAtualizado) {
        Optional<Pedido> pedidoExistente = pedidoRepository.findById(id);

        if (pedidoExistente.isPresent()) {
            Pedido pedido = pedidoExistente.get();
            pedido.setClienteId(pedidoAtualizado.getClienteId());
            pedido.setProdutoId(pedidoAtualizado.getProdutoId());
            pedido.setQuantidade(pedidoAtualizado.getQuantidade());
            return ResponseEntity.ok(pedidoRepository.save(pedido));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /pedidos/{id} - exclui um pedido pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (pedidoRepository.existsById(id)) {
            pedidoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
