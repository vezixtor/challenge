package com.herokuapp.infopricechallenge.bdd.scenario;

import br.com.six2six.fixturefactory.Fixture;
import com.herokuapp.infopricechallenge.bdd.scenario.common.BaseScenario;
import com.herokuapp.infopricechallenge.bdd.scenario.common.Scenario;
import com.herokuapp.infopricechallenge.model.adapter.EnderecoAdapter;
import com.herokuapp.infopricechallenge.model.dto.v1.EnderecoDTO;
import com.herokuapp.infopricechallenge.model.entity.Endereco;
import com.herokuapp.infopricechallenge.repository.EnderecoRepository;
import com.herokuapp.infopricechallenge.template.CommonTemplateLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnderecoScenario extends BaseScenario implements Scenario {
    
    @Autowired
    private EnderecoRepository repository;
    
    @Override
    public EnderecoRepository getRepository() {
        return repository;
    }
    
    @Override
    public Endereco gimmeEntity() {
        Endereco entity = Fixture.from(Endereco.class)
            .gimme(CommonTemplateLoader.RULE_VALID_WITHOUT_FK);

        return entity;
    }
    
    @Override
    public List<Endereco> gimmeEntity(Integer quantity) {
        List<Endereco> entities = new ArrayList<>();
        while (entities.size() < quantity) {
            entities.add(gimmeEntity());
        }
        return entities;
    }
    
    @Override
    public Endereco gimmeEntitySaved() {
        return repository.save(gimmeEntity());
    }
    
    @Override
    public List<Endereco> gimmeEntitySaved(Integer quantity) {
        return gimmeEntity(quantity).stream()
            .map(entity -> repository.save(entity))
            .collect(Collectors.toList());
    }
    
    @Override
    public EnderecoDTO gimmeDTO() {
        return EnderecoAdapter.toDTO(gimmeEntity());
    }
    
    @Override
    public List<EnderecoDTO> gimmeDTO(Integer quantity) {
        return EnderecoAdapter.toDTO(gimmeEntity(quantity));
    }
}