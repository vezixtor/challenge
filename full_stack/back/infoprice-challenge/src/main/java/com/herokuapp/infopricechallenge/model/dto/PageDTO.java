package com.herokuapp.infopricechallenge.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort.Direction;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageDTO {

    @ApiModelProperty(hidden = true)
    boolean firstPage;

    @ApiModelProperty(hidden = true)
    boolean lastPage;

    @ApiModelProperty(hidden = true)
    long totalPages;
    int limit = 20;
    int offset = 20;

    @ApiModelProperty(hidden = true)
    int numberOfElements;

    @ApiModelProperty(hidden = true)
    long totalElements;
    String[] sortBy;
    Direction sortDirection;
}