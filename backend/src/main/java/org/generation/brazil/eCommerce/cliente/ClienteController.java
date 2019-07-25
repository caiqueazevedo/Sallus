package org.generation.brazil.eCommerce.cliente;

import org.generation.brazil.eCommerce.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("clientes")
public class ClienteController {

    private final Logger LOGGER = LoggerFactory.getLogger(ClienteController.class);

    @Autowired
    private ClienteRepository clienteRepository;

    // CREATE
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/clientes")
    public Cliente save(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // READ
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/clientes")
    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    @GetMapping("/clientes/{id}")
    public Optional<Cliente> findById(@PathVariable Long id) {
        return clienteRepository.findById(id);
    }

    @GetMapping("/clientes/filter/nome") // ?nome=Hélio Pierazzo
    public List<Cliente> findByNome(@RequestParam String nome) {
        return clienteRepository.findByNome(nome);
    }

    @GetMapping("/clientes/filter/data-nascimento") // ?data-nascimento=1990-07-18
    public List<Cliente> findByDataNascimento(
            @RequestParam(value = "data-nascimento") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataNascimento) {
        return clienteRepository.findByDataNascimento(dataNascimento);
    }

    // UPDATE
    @PutMapping("/clientes/{id}")
    public Cliente update(@PathVariable Long id, @RequestBody Cliente cliente)
            throws ResourceNotFoundException {
        return clienteRepository.findById(id).map(c -> {
            c.setNome(cliente.getNome());
            c.setEndereco(cliente.getEndereco());
            c.setCpf(cliente.getCpf());
            c.setDataCadastro(cliente.getDataCadastro());
            c.setDataNascimento(cliente.getDataNascimento());
            c.setSexo(cliente.getSexo());
            return clienteRepository.save(c);
        }).orElseThrow(()->
                new ResourceNotFoundException("Não existe cliente cadastrado com este ID (" + id +")"));
    }

    @PatchMapping("/clientes/update/{id}")
    public Optional<Cliente> updateNomeById(@PathVariable Long id, @RequestParam String nome) {
        clienteRepository.updateNomeById(nome, id);
        return clienteRepository.findById(id);
    }

    // DELETE
    @DeleteMapping("/clientes/{id}")
    public void delete(@PathVariable Long id){
        clienteRepository.deleteById(id);
    }

    @DeleteMapping("/clientes/delete-by")
    public void deleteByDataNascimentoAndNome(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataNascimento,
            @RequestParam String nome) {
        // "DELETE FROM cliente WHERE data_nascimento = ... AND nome = ..."
        clienteRepository.deleteByDataNascimentoAndNome(dataNascimento, nome);
    }
}
