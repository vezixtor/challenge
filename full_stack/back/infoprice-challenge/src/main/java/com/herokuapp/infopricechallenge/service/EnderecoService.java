package com.herokuapp.infopricechallenge.service;

import com.herokuapp.infopricechallenge.model.dto.v1.EnderecoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EnderecoService {

    Page<EnderecoDTO> findAll(Pageable pageable);

    EnderecoDTO findOne(Long id);

    EnderecoDTO save(EnderecoDTO dto);

    EnderecoDTO update(Long id, EnderecoDTO dto);

    void delete(Long id);
}