package com.herokuapp.infopricechallenge.service.impl;

import com.herokuapp.infopricechallenge.model.adapter.PessoaAdapter;
import com.herokuapp.infopricechallenge.model.dto.ListResultDTO;
import com.herokuapp.infopricechallenge.model.dto.PageDTO;
import com.herokuapp.infopricechallenge.model.dto.v1.PessoaDTO;
import com.herokuapp.infopricechallenge.model.entity.Pessoa;
import com.herokuapp.infopricechallenge.repository.PessoaRepository;
import com.herokuapp.infopricechallenge.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private PessoaRepository repository;

    @Override
    public ListResultDTO<PessoaDTO> findAll(PessoaDTO dto, PageDTO page) {
        List<Pessoa> entitiesPage = this.repository.findAll();

        List<PessoaDTO> entitiesDTO = entitiesPage.stream()
                .map(PessoaAdapter::toDTO)
                .collect(Collectors.toList());

        return new ListResultDTO<>(entitiesDTO);
    }

    @Override
    public PessoaDTO findOne(Long id) {
        Optional<Pessoa> entity = this.repository.findById(id);
        return PessoaAdapter.toDTO(entity.get());
    }

    @Override
    public PessoaDTO save(PessoaDTO dto) {
        Pessoa entity = PessoaAdapter.toEntity(dto);
        this.repository.save(entity);
        return PessoaAdapter.toDTO(entity);
    }

    @Override
    public PessoaDTO update(Long id, PessoaDTO dto) {
        Pessoa newEntity = PessoaAdapter.toEntity(dto);
        Optional<Pessoa> entity = this.repository.findById(id);
        //entity.update(newEntity); //TODO update(newEntity) precisa ser implementado na entidade
        Pessoa saved = this.repository.save(entity.get());
        return PessoaAdapter.toDTO(saved);
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }
}