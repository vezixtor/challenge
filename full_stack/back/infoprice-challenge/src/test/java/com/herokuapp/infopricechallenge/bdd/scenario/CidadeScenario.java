package com.herokuapp.infopricechallenge.bdd.scenario;

import br.com.six2six.fixturefactory.Fixture;
import com.herokuapp.infopricechallenge.bdd.scenario.common.BaseScenario;
import com.herokuapp.infopricechallenge.bdd.scenario.common.Scenario;
import com.herokuapp.infopricechallenge.model.adapter.CidadeAdapter;
import com.herokuapp.infopricechallenge.model.dto.v1.CidadeDTO;
import com.herokuapp.infopricechallenge.model.entity.Cidade;
import com.herokuapp.infopricechallenge.repository.CidadeRepository;
import com.herokuapp.infopricechallenge.template.CommonTemplateLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CidadeScenario extends BaseScenario implements Scenario {
    
    @Autowired
    private CidadeRepository repository;
    
    @Override
    public CidadeRepository getRepository() {
        return repository;
    }
    
    @Override
    public Cidade gimmeEntity() {
        Cidade entity = Fixture.from(Cidade.class)
            .gimme(CommonTemplateLoader.RULE_VALID_WITHOUT_FK);

        return entity;
    }
    
    @Override
    public List<Cidade> gimmeEntity(Integer quantity) {
        List<Cidade> entities = new ArrayList<>();
        while (entities.size() < quantity) {
            entities.add(gimmeEntity());
        }
        return entities;
    }
    
    @Override
    public Cidade gimmeEntitySaved() {
        return repository.save(gimmeEntity());
    }
    
    @Override
    public List<Cidade> gimmeEntitySaved(Integer quantity) {
        return gimmeEntity(quantity).stream()
            .map(entity -> repository.save(entity))
            .collect(Collectors.toList());
    }
    
    @Override
    public CidadeDTO gimmeDTO() {
        return CidadeAdapter.toDTO(gimmeEntity());
    }
    
    @Override
    public List<CidadeDTO> gimmeDTO(Integer quantity) {
        return CidadeAdapter.toDTO(gimmeEntity(quantity));
    }
}