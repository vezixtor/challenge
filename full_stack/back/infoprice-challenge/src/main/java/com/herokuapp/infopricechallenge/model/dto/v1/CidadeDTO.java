package com.herokuapp.infopricechallenge.model.dto.v1;

import com.herokuapp.infopricechallenge.model.type.Estado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CidadeDTO {
    private Long id;
    private String nome;
    private Estado estado;
}