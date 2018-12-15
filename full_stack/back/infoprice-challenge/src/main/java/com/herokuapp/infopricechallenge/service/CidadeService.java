package com.herokuapp.infopricechallenge.service;

import com.herokuapp.infopricechallenge.model.dto.ListResultDTO;
import com.herokuapp.infopricechallenge.model.dto.PageDTO;
import com.herokuapp.infopricechallenge.model.dto.v1.CidadeDTO;

public interface CidadeService {
    
    ListResultDTO<CidadeDTO> findAll(CidadeDTO dto, PageDTO page);
    
    CidadeDTO findOne(Long id);
    
    CidadeDTO save(CidadeDTO dto);
    
    CidadeDTO update(Long id, CidadeDTO dto);
    
    void delete(Long id);
}