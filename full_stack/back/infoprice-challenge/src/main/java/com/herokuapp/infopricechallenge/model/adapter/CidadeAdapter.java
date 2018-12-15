package com.herokuapp.infopricechallenge.model.adapter;

import com.herokuapp.infopricechallenge.model.dto.v1.CidadeDTO;
import com.herokuapp.infopricechallenge.model.entity.Cidade;
import java.util.List;
import java.util.stream.Collectors;

public class CidadeAdapter {
    
    public static List<CidadeDTO> toDTO(List<Cidade> entities) {
        return entities.stream().map(CidadeAdapter::toDTO).collect(Collectors.toList());
    }
    
    public static CidadeDTO toDTO(Cidade entity) {
        if (entity == null) {
            return null;
        }


        return CidadeDTO.builder()
            .id(entity.getId())
            .nome(entity.getNome())
            .estado(entity.getEstado())
            .build();
    }
    
    public static List<Cidade> toEntity(List<CidadeDTO> dtos) {
        return dtos.stream().map(CidadeAdapter::toEntity).collect(Collectors.toList());
    }
    
    public static Cidade toEntity(CidadeDTO dto) {
        if (dto == null) {
            return null;
        }


        return Cidade.builder()
            .id(dto.getId())
            .nome(dto.getNome())
            .estado(dto.getEstado())
            .build();
    }
}