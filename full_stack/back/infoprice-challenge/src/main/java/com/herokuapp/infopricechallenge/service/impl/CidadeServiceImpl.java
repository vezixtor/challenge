package com.herokuapp.infopricechallenge.service.impl;

import com.herokuapp.infopricechallenge.model.adapter.CidadeAdapter;
import com.herokuapp.infopricechallenge.model.dto.ListResultDTO;
import com.herokuapp.infopricechallenge.model.dto.PageDTO;
import com.herokuapp.infopricechallenge.model.dto.v1.CidadeDTO;
import com.herokuapp.infopricechallenge.model.entity.Cidade;
import com.herokuapp.infopricechallenge.repository.CidadeRepository;
import com.herokuapp.infopricechallenge.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CidadeServiceImpl implements CidadeService {

    @Autowired
    private CidadeRepository repository;

    @Override
    public ListResultDTO<CidadeDTO> findAll(CidadeDTO dto, PageDTO page) {
        List<Cidade> entitiesPage = this.repository.findAll();

        List<CidadeDTO> entitiesDTO = entitiesPage.stream()
                .map(CidadeAdapter::toDTO)
                .collect(Collectors.toList());

        return new ListResultDTO<>(entitiesDTO);
    }

    @Override
    public CidadeDTO findOne(Long id) {
        Optional<Cidade> entity = this.repository.findById(id);
        return CidadeAdapter.toDTO(entity.get());
    }

    @Override
    public CidadeDTO save(CidadeDTO dto) {
        Cidade entity = CidadeAdapter.toEntity(dto);
        this.repository.save(entity);
        return CidadeAdapter.toDTO(entity);
    }

    @Override
    public CidadeDTO update(Long id, CidadeDTO dto) {
        Cidade newEntity = CidadeAdapter.toEntity(dto);
        Optional<Cidade> entity = this.repository.findById(id);
        //entity.update(newEntity); //TODO update(newEntity) precisa ser implementado na entidade
        Cidade saved = this.repository.save(entity.get());
        return CidadeAdapter.toDTO(saved);
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }
}