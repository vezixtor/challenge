package com.herokuapp.infopricechallenge.model.adapter;

import com.herokuapp.infopricechallenge.model.dto.v1.CidadeDTO;
import com.herokuapp.infopricechallenge.model.dto.v1.EnderecoDTO;
import com.herokuapp.infopricechallenge.model.dto.v1.PessoaDTO;
import com.herokuapp.infopricechallenge.model.entity.Cidade;
import com.herokuapp.infopricechallenge.model.entity.Endereco;
import com.herokuapp.infopricechallenge.model.entity.Pessoa;
import java.util.List;
import java.util.stream.Collectors;

public class EnderecoAdapter {
    
    public static List<EnderecoDTO> toDTO(List<Endereco> entities) {
        return entities.stream().map(EnderecoAdapter::toDTO).collect(Collectors.toList());
    }
    
    public static EnderecoDTO toDTO(Endereco entity) {
        if (entity == null) {
            return null;
        }

        PessoaDTO pessoa = PessoaAdapter.toDTO(entity.getPessoa());
        CidadeDTO cidade = CidadeAdapter.toDTO(entity.getCidade());

        return EnderecoDTO.builder()
            .id(entity.getId())
            .pessoa(pessoa)
            .logradouro(entity.getLogradouro())
            .numero(entity.getNumero())
            .complemento(entity.getComplemento())
            .bairro(entity.getBairro())
            .cidade(cidade)
            .cep(entity.getCep())
            .build();
    }
    
    public static List<Endereco> toEntity(List<EnderecoDTO> dtos) {
        return dtos.stream().map(EnderecoAdapter::toEntity).collect(Collectors.toList());
    }
    
    public static Endereco toEntity(EnderecoDTO dto) {
        if (dto == null) {
            return null;
        }

        Pessoa pessoa = PessoaAdapter.toEntity(dto.getPessoa());
        Cidade cidade = CidadeAdapter.toEntity(dto.getCidade());

        return Endereco.builder()
            .id(dto.getId())
            .pessoa(pessoa)
            .logradouro(dto.getLogradouro())
            .numero(dto.getNumero())
            .complemento(dto.getComplemento())
            .bairro(dto.getBairro())
            .cidade(cidade)
            .cep(dto.getCep())
            .build();
    }
}