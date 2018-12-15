package com.herokuapp.infopricechallenge.model.adapter;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.herokuapp.infopricechallenge.model.dto.v1.PessoaDTO;
import com.herokuapp.infopricechallenge.model.entity.Pessoa;
import com.herokuapp.infopricechallenge.template.CommonTemplateLoader;
import com.herokuapp.infopricechallenge.template.dto.PessoaDTOTemplateLoader;
import com.herokuapp.infopricechallenge.template.entity.PessoaTemplateLoader;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class PessoaAdapterTest {
    private Pessoa entity;
    private PessoaDTO dto;
    private Pessoa entityConvert;
    private PessoaDTO dtoConvert;
    
    @BeforeClass
    public static void loadTemplates() {
        FixtureFactoryLoader.loadTemplates(CommonTemplateLoader.FIXTURE_FACTORY_BASE_PACKAGE);
    }
    
    @Before
    public void setup() {
        entity = Fixture.from(Pessoa.class).gimme(PessoaTemplateLoader.RULE_VALID);
        dtoConvert = PessoaAdapter.toDTO(entity);
        dto = Fixture.from(PessoaDTO.class).gimme(PessoaDTOTemplateLoader.RULE_VALID);
        entityConvert = PessoaAdapter.toEntity(dto);
    }
    
    @Test
    public void entityToDTO() {
        assertThat(dto.getId(), equalTo(entityConvert.getId()));
        assertThat(dto.getNome(), equalTo(entityConvert.getNome()));
        assertThat(dto.getEmail(), equalTo(entityConvert.getEmail()));
        assertThat(dto.getEnderecos().size(), is(entityConvert.getEnderecos().size()));
    }
    
    @Test
    public void DTOToEntity() {
        assertThat(entity.getId(), equalTo(dtoConvert.getId()));
        assertThat(entity.getNome(), equalTo(dtoConvert.getNome()));
        assertThat(entity.getEmail(), equalTo(dtoConvert.getEmail()));
        assertThat(entity.getEnderecos().size(), is(dtoConvert.getEnderecos().size()));
    }
    
    @Test
    public void entityNull() {
        PessoaDTO dto = null;
        Pessoa entity = PessoaAdapter.toEntity(dto);
        assertNull(entity);
    }
    
    @Test
    public void dtoNull() {
        Pessoa entity = null;
        PessoaDTO dto = PessoaAdapter.toDTO(entity);
        assertNull(dto);
    }
}