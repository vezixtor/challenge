package com.herokuapp.infopricechallenge.service.impl;

import com.herokuapp.infopricechallenge.model.adapter.CidadeAdapter;
import com.herokuapp.infopricechallenge.model.dto.v1.CidadeDTO;
import com.herokuapp.infopricechallenge.model.entity.Cidade;
import com.herokuapp.infopricechallenge.model.type.Estado;
import com.herokuapp.infopricechallenge.repository.CidadeRepository;
import com.herokuapp.infopricechallenge.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CidadeServiceImpl implements CidadeService {

    @Autowired
    private CidadeRepository repository;

    @Override
    public Page<CidadeDTO> findAll(Pageable pageable) {
        Page<Cidade> entitiesPage = this.repository.findAll(pageable);

        List<CidadeDTO> dtos = entitiesPage.stream()
                .map(CidadeAdapter::toDTO)
                .collect(Collectors.toList());

        return new PageImpl(dtos, entitiesPage.getPageable(), entitiesPage.getTotalElements());
    }

    @Override
    public CidadeDTO findOne(Long id) {
        Cidade entity = this.repository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
        return CidadeAdapter.toDTO(entity);
    }

    @Override
    public CidadeDTO save(CidadeDTO dto) {
        Cidade entity = CidadeAdapter.toEntity(dto);
        Cidade saved = this.repository.save(entity);
        return CidadeAdapter.toDTO(saved);
    }

    @Override
    public CidadeDTO update(Long id, CidadeDTO dto) {
        Cidade cidade = this.repository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
        Cidade newEntity = CidadeAdapter.toEntity(dto);
        cidade.put(newEntity);
        Cidade saved = this.repository.save(cidade);
        return CidadeAdapter.toDTO(saved);
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public Page<CidadeDTO> findByEstado(Estado estado, Pageable pageable) {
        Page<Cidade> entitiesPage = this.repository.findByEstado(estado, pageable);

        List<CidadeDTO> dtos = entitiesPage.stream()
                .map(CidadeAdapter::toDTO)
                .collect(Collectors.toList());

        return new PageImpl(dtos, entitiesPage.getPageable(), entitiesPage.getTotalElements());
    }
}