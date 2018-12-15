package com.herokuapp.infopricechallenge.service;

import com.herokuapp.infopricechallenge.model.dto.ListResultDTO;
import com.herokuapp.infopricechallenge.model.dto.PageDTO;
import com.herokuapp.infopricechallenge.model.dto.v1.EnderecoDTO;

public interface EnderecoService {
    
    ListResultDTO<EnderecoDTO> findAll(EnderecoDTO dto, PageDTO page);
    
    EnderecoDTO findOne(Long id);
    
    EnderecoDTO save(EnderecoDTO dto);
    
    EnderecoDTO update(Long id, EnderecoDTO dto);
    
    void delete(Long id);
}