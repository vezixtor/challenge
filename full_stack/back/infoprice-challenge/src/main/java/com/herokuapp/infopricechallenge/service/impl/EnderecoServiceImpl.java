package com.herokuapp.infopricechallenge.service.impl;

import com.herokuapp.infopricechallenge.model.adapter.EnderecoAdapter;
import com.herokuapp.infopricechallenge.model.dto.v1.EnderecoDTO;
import com.herokuapp.infopricechallenge.model.entity.Endereco;
import com.herokuapp.infopricechallenge.repository.EnderecoRepository;
import com.herokuapp.infopricechallenge.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    @Override
    public Page<EnderecoDTO> findAll(Pageable pageable) {
        Page<Endereco> entitiesPage = this.repository.findAll(pageable);

        List<EnderecoDTO> dtos = entitiesPage.stream()
                .map(EnderecoAdapter::toDTO)
                .collect(Collectors.toList());

        return new PageImpl(dtos, entitiesPage.getPageable(), entitiesPage.getTotalElements());
    }

    @Override
    public EnderecoDTO findOne(Long id) {
        Endereco entity = this.repository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
        return EnderecoAdapter.toDTO(entity);
    }

    @Override
    public EnderecoDTO save(EnderecoDTO dto) {
        Endereco entity = EnderecoAdapter.toEntity(dto);
        Endereco saved = this.repository.save(entity);
        return EnderecoAdapter.toDTO(saved);
    }

    @Override
    public EnderecoDTO update(Long id, EnderecoDTO dto) {
        Endereco pessoa = this.repository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
        Endereco newEntity = EnderecoAdapter.toEntity(dto);
        pessoa.put(newEntity);
        Endereco saved = this.repository.save(pessoa);
        return EnderecoAdapter.toDTO(saved);
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }
}