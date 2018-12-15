package com.herokuapp.infopricechallenge.bdd.scenario;

import br.com.six2six.fixturefactory.Fixture;
import com.herokuapp.infopricechallenge.bdd.scenario.common.BaseScenario;
import com.herokuapp.infopricechallenge.bdd.scenario.common.Scenario;
import com.herokuapp.infopricechallenge.model.adapter.PessoaAdapter;
import com.herokuapp.infopricechallenge.model.dto.v1.PessoaDTO;
import com.herokuapp.infopricechallenge.model.entity.Pessoa;
import com.herokuapp.infopricechallenge.repository.PessoaRepository;
import com.herokuapp.infopricechallenge.template.CommonTemplateLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PessoaScenario extends BaseScenario implements Scenario {
    
    @Autowired
    private PessoaRepository repository;
    
    @Override
    public PessoaRepository getRepository() {
        return repository;
    }
    
    @Override
    public Pessoa gimmeEntity() {
        Pessoa entity = Fixture.from(Pessoa.class)
            .gimme(CommonTemplateLoader.RULE_VALID_WITHOUT_FK);

        return entity;
    }
    
    @Override
    public List<Pessoa> gimmeEntity(Integer quantity) {
        List<Pessoa> entities = new ArrayList<>();
        while (entities.size() < quantity) {
            entities.add(gimmeEntity());
        }
        return entities;
    }
    
    @Override
    public Pessoa gimmeEntitySaved() {
        return repository.save(gimmeEntity());
    }
    
    @Override
    public List<Pessoa> gimmeEntitySaved(Integer quantity) {
        return gimmeEntity(quantity).stream()
            .map(entity -> repository.save(entity))
            .collect(Collectors.toList());
    }
    
    @Override
    public PessoaDTO gimmeDTO() {
        return PessoaAdapter.toDTO(gimmeEntity());
    }
    
    @Override
    public List<PessoaDTO> gimmeDTO(Integer quantity) {
        return PessoaAdapter.toDTO(gimmeEntity(quantity));
    }
}