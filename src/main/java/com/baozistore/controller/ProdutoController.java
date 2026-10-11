package com.baozistore.controller;

import com.baozistore.model.Produto;
import com.baozistore.repository.ProdutoRepository;
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
// @RequestMapping define o caminho base para todos os endpoints desse controller.
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    // @Autowired faz o Spring injetar o repository automaticamente.
    @Autowired
    private ProdutoRepository produtoRepository;

    // POST /produtos - cadastra um novo produto
    @PostMapping
    public Produto cadastrar(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    // GET /produtos - lista todos os produtos
    @GetMapping
    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    // GET /produtos/{id} - busca um produto pelo ID
    // Se nao encontrar, retorna 404 (Not Found).
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);

        if (produto.isPresent()) {
            return ResponseEntity.ok(produto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // PUT /produtos/{id} - atualiza os dados de um produto existente
    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
        Optional<Produto> produtoExistente = produtoRepository.findById(id);

        if (produtoExistente.isPresent()) {
            Produto produto = produtoExistente.get();
            produto.setNome(produtoAtualizado.getNome());
            produto.setPreco(produtoAtualizado.getPreco());
            produto.setEstoque(produtoAtualizado.getEstoque());
            return ResponseEntity.ok(produtoRepository.save(produto));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /produtos/{id} - exclui um produto pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
