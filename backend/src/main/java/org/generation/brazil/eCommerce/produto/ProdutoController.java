package org.generation.brazil.eCommerce.produto;

import org.generation.brazil.eCommerce.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    // CREATE
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/produtos")
    public Produto save(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    // READ
    @GetMapping("/produtos")
    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    @GetMapping("/produtos/{id}")
    public Optional<Produto> findById(@PathVariable Long id) {
        return produtoRepository.findById(id);
    }

    @GetMapping("/produtos/filter") // ?nome=Água Mineral
    public List<Produto> findByNome(@RequestParam String nome) {
        return produtoRepository.findByNome(nome);
    }

    @GetMapping("/produtos/filter/valor/less-than") // ?valor=10.00
    public List<Produto> findByValorLessThan(@RequestParam BigDecimal valor) {
        return produtoRepository.findByValorLessThan(valor);
    }

    @GetMapping("/produtos/filter/valor/greater-than") // ?valor=10.00
    public List<Produto> findByValorGreaterThan(@RequestParam BigDecimal valor) {
        return produtoRepository.findByValorGreaterThan(valor);
    }

    @GetMapping("/produtos/filter/between") // ?minimo=10.00&maximo=20.00
    public List<Produto> findByValorBetween(@RequestParam BigDecimal minimo, BigDecimal maximo) {
        return produtoRepository.findByValorBetween(minimo, maximo);
    }

    // UPDATE
    @PutMapping("/produtos/{id}")
    public Produto update(@PathVariable Long id, @RequestBody Produto produto)
            throws ResourceNotFoundException {
        return produtoRepository.findById(id).map(p -> {
            p.setNome(produto.getNome());
            p.setValor(produto.getValor());
            return produtoRepository.save(p);
        }).orElseThrow(()->
                new ResourceNotFoundException("Não existe produto cadastrado com esse ID (" + id +")"));
    }

    @PatchMapping("/produtos/update/{id}")
    public Optional<Produto> updateValorById(@PathVariable Long id, @RequestParam BigDecimal valor) {
        produtoRepository.updateValorById(valor, id);
        return produtoRepository.findById(id);
    }

    // DELETE
    @DeleteMapping("/produtos/{id}")
    public void delete(@PathVariable Long id){
        produtoRepository.deleteById(id);
    }

    @DeleteMapping("/produtos/delete-by")
    public void deleteByValorLessThan(@RequestParam BigDecimal valor) {
        // "DELETE FROM produto WHERE preco < ..."
        produtoRepository.deleteByValorLessThan(valor);
    }

    /**
     * ## Utilização da Paginação
     *
     * ?page=0         ->   Irá mostrar os itens da página 0
     * ?page=0&size=5  ->   Irá mostrar os itens da página 0 e a página terá apenas 5 itens
     *
     * ## Utilização da Ordenação
     *
     * ?sort=nome,asc  ->   Vai organizar os itens por nome na ordem alfabética crescente
     * ?sort=nome,desc ->   Vai organizar os itens por nome na ordem alfabética decrescente
     */

    @GetMapping("/produtos/") // ?page=0 | ?page=0&size=5
    public ResponseEntity<?> listAall(Pageable pageable){
        return new ResponseEntity<>(produtoRepository.findAll(pageable), HttpStatus.OK);
    }

    //List<Produto> allCemReaisProdutos = produtoRepository.findAllByValor(10, secondPageWithFiveElements);

}