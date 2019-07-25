package org.generation.brazil.eCommerce.usuario;

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
public class UsuarioController {

    private final Logger LOGGER = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    // CREATE
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/clientes")
    public Usuario save(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // READ
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/clientes")
    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    @GetMapping("/clientes/{id}")
    public Optional<Usuario> findById(@PathVariable Long id) {
        return usuarioRepository.findById(id);
    }

    @GetMapping("/clientes/filter/nome") // ?nome=Hélio Pierazzo
    public List<Usuario> findByNome(@RequestParam String nome) {
        return usuarioRepository.findByNome(nome);
    }

    @GetMapping("/clientes/filter/data-nascimento") // ?data-nascimento=1990-07-18
    public List<Usuario> findByDataNascimento(
            @RequestParam(value = "data-nascimento") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataNascimento) {
        return usuarioRepository.findByDataNascimento(dataNascimento);
    }

    // UPDATE
    @PutMapping("/clientes/{id}")
    public Usuario update(@PathVariable Long id, @RequestBody Usuario usuario)
            throws ResourceNotFoundException {
        return usuarioRepository.findById(id).map(c -> {
            c.setNome(usuario.getNome());
            c.setEndereco(usuario.getEndereco());
            c.setCpf(usuario.getCpf());
            c.setDataCadastro(usuario.getDataCadastro());
            c.setDataNascimento(usuario.getDataNascimento());
            c.setSexo(usuario.getSexo());
            return usuarioRepository.save(c);
        }).orElseThrow(()->
                new ResourceNotFoundException("Não existe usuario cadastrado com este ID (" + id +")"));
    }

    @PatchMapping("/clientes/update/{id}")
    public Optional<Usuario> updateNomeById(@PathVariable Long id, @RequestParam String nome) {
        usuarioRepository.updateNomeById(nome, id);
        return usuarioRepository.findById(id);
    }

    // DELETE
    @DeleteMapping("/clientes/{id}")
    public void delete(@PathVariable Long id){
        usuarioRepository.deleteById(id);
    }

    @DeleteMapping("/clientes/delete-by")
    public void deleteByDataNascimentoAndNome(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataNascimento,
            @RequestParam String nome) {
        // "DELETE FROM usuario WHERE data_nascimento = ... AND nome = ..."
        usuarioRepository.deleteByDataNascimentoAndNome(dataNascimento, nome);
    }
}
