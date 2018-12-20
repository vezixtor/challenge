package com.herokuapp.infopricechallenge.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Builder
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

    public void put(Endereco entity) {
        if (entity != null) {
            this.pessoa = entity.getPessoa();
            this.logradouro = entity.getLogradouro();
            this.numero = entity.getNumero();
            this.complemento = entity.getComplemento();
            this.bairro = entity.getBairro();
            this.cidade = entity.getCidade();
            this.cep = entity.getCep();
        }
    }
}
