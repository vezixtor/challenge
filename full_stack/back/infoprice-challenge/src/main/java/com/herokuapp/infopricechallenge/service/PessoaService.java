package com.herokuapp.infopricechallenge.service;

import com.herokuapp.infopricechallenge.model.dto.ListResultDTO;
import com.herokuapp.infopricechallenge.model.dto.PageDTO;
import com.herokuapp.infopricechallenge.model.dto.v1.PessoaDTO;

public interface PessoaService {
    
    ListResultDTO<PessoaDTO> findAll(PessoaDTO dto, PageDTO page);
    
    PessoaDTO findOne(Long id);
    
    PessoaDTO save(PessoaDTO dto);
    
    PessoaDTO update(Long id, PessoaDTO dto);
    
    void delete(Long id);
}