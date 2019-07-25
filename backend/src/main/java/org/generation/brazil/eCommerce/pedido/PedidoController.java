package org.generation.brazil.eCommerce.pedido;

import org.generation.brazil.eCommerce.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    // CREATE
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/pedidos")
    public Pedido save(@RequestBody Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    // READ
    @GetMapping("/pedidos")
    public List<Pedido> findAll(){
        return pedidoRepository.findAll();
    }

    @GetMapping("/pedidos/{id}")
    public Optional<Pedido> findById(@PathVariable Long id) {
        return pedidoRepository.findById(id);
    }

    // UPDATE
    @PutMapping("/pedidos/{id}")
    public Pedido update(@PathVariable Long id, @RequestBody Pedido pedido)
            throws ResourceNotFoundException {
        return pedidoRepository.findById(id).map(p -> {
            p.setDataPedido(pedido.getDataPedido());
            p.setValorPedido(pedido.getValorPedido());
            return pedidoRepository.save(p);
        }).orElseThrow(()->
                new ResourceNotFoundException("Não existe pedido cadastrado com esse ID (" + id +")"));
    }

    // DELETE
    @DeleteMapping("/pedidos/{id}")
    public void delete(@PathVariable Long id){
        pedidoRepository.deleteById(id);
    }
}
