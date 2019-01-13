package com.herokuapp.infopricechallenge.service;

import com.herokuapp.infopricechallenge.model.dto.v1.CidadeDTO;
import com.herokuapp.infopricechallenge.model.type.Estado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CidadeService {

    Page<CidadeDTO> findAll(Pageable pageable);

    CidadeDTO findOne(Long id);

    CidadeDTO save(CidadeDTO dto);

    CidadeDTO update(Long id, CidadeDTO dto);

    void delete(Long id);

    Page<CidadeDTO> findByEstado(Estado estado, Pageable pageable);
}