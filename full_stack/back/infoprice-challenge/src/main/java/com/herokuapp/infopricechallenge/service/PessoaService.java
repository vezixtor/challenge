package com.herokuapp.infopricechallenge.service;

import com.herokuapp.infopricechallenge.model.dto.v1.PessoaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PessoaService {

    Page<PessoaDTO> findAll(Pageable pageable);

    PessoaDTO findOne(Long id);

    PessoaDTO save(PessoaDTO dto);

    PessoaDTO update(Long id, PessoaDTO dto);

    void delete(Long id);
}