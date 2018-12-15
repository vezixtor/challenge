package com.herokuapp.infopricechallenge.model.adapter;

import com.herokuapp.infopricechallenge.model.dto.v1.EnderecoDTO;
import com.herokuapp.infopricechallenge.model.dto.v1.PessoaDTO;
import com.herokuapp.infopricechallenge.model.entity.Endereco;
import com.herokuapp.infopricechallenge.model.entity.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PessoaAdapter {

    public static List<PessoaDTO> toDTO(List<Pessoa> entities) {
        return entities.stream().map(PessoaAdapter::toDTO).collect(Collectors.toList());
    }

    public static PessoaDTO toDTO(Pessoa entity) {
        if (entity == null) {
            return null;
        }

        List<EnderecoDTO> enderecos = new ArrayList<>();
        if (entity.getEnderecos() != null && !entity.getEnderecos().isEmpty()) {
            for (Endereco item : entity.getEnderecos()) {
                enderecos.add(EnderecoAdapter.toDTO(item));
            }
        }

        return PessoaDTO.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .email(entity.getEmail())
                .enderecos(enderecos)
                .build();
    }

    public static List<Pessoa> toEntity(List<PessoaDTO> dtos) {
        return dtos.stream().map(PessoaAdapter::toEntity).collect(Collectors.toList());
    }

    public static Pessoa toEntity(PessoaDTO dto) {
        if (dto == null) {
            return null;
        }

        List<Endereco> enderecos = new ArrayList<>();
        if (dto.getEnderecos() != null && !dto.getEnderecos().isEmpty()) {
            for (EnderecoDTO item : dto.getEnderecos()) {
                enderecos.add(EnderecoAdapter.toEntity(item));
            }
        }

        return Pessoa.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .email(dto.getEmail())
                .enderecos(enderecos)
                .build();
    }
}