package com.herokuapp.infopricechallenge.service.impl;

import com.herokuapp.infopricechallenge.model.adapter.EnderecoAdapter;
import com.herokuapp.infopricechallenge.model.dto.ListResultDTO;
import com.herokuapp.infopricechallenge.model.dto.PageDTO;
import com.herokuapp.infopricechallenge.model.dto.v1.EnderecoDTO;
import com.herokuapp.infopricechallenge.model.entity.Endereco;
import com.herokuapp.infopricechallenge.repository.EnderecoRepository;
import com.herokuapp.infopricechallenge.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnderecoServiceImpl implements EnderecoService {
    
    @Autowired
    private EnderecoRepository repository;
    
    @Override
    public ListResultDTO<EnderecoDTO> findAll(EnderecoDTO dto, PageDTO page) {
        List<Endereco> entitiesPage = this.repository.findAll();

        List<EnderecoDTO> entitiesDTO = entitiesPage.stream()
            .map(EnderecoAdapter::toDTO)
            .collect(Collectors.toList());

        return new ListResultDTO<>(entitiesDTO);
    }
    
    @Override
    public EnderecoDTO findOne(Long id) {
        Optional<Endereco> entity = this.repository.findById(id);
        return EnderecoAdapter.toDTO(entity.get());
    }
    
    @Override
    public EnderecoDTO save(EnderecoDTO dto) {
        Endereco entity = EnderecoAdapter.toEntity(dto);
        Endereco saved = this.repository.save(entity);
        return EnderecoAdapter.toDTO(saved);
    }
    
    @Override
    public EnderecoDTO update(Long id, EnderecoDTO dto) {
        Endereco newEntity = EnderecoAdapter.toEntity(dto);
        Optional<Endereco> entity = this.repository.findById(id);
        //entity.update(newEntity); //TODO update(newEntity) precisa ser implementado na entidade
        Endereco saved = this.repository.save(entity.get());
        return EnderecoAdapter.toDTO(saved);
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }
}