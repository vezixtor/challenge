package com.herokuapp.infopricechallenge.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(columnDefinition = "enderecos")
    private Pessoa pessoa;

    private String logradouro;

    private String numero;

    private String complemento;

    private String bairro;

    @NotNull
    @ManyToOne
    private Cidade cidade;

    private String cep;
}
