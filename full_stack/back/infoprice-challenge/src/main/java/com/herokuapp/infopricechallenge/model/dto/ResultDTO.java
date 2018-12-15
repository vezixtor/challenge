package com.herokuapp.infopricechallenge.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ResultDTO<T> {
    private T content;
    
    public ResultDTO(T content) {
        this.content = content;
    }
}