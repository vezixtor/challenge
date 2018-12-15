package com.herokuapp.infopricechallenge.model.dto.v1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {
    private Long id;
    private PessoaDTO pessoa;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private CidadeDTO cidade;
    private String cep;
}