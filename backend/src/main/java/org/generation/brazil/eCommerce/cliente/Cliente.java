package org.generation.brazil.eCommerce.cliente;

import lombok.Data;
import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;

    @NotNull
    @Column(name = "nome")
    private String nome;

    @NotNull
    @Column(name = "cpf")
    private String cpf;

    @NotNull
    @Column(name = "endereco")
    private String endereco;

    @NotNull
    @Column(name = "data_nascimento")
    public LocalDate dataNascimento;

    @NotNull
    @Column(name = "data_cadastro")
    public LocalDate dataCadastro;

    @Column(name = "sexo")
    private char sexo;

}