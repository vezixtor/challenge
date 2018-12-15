package com.herokuapp.infopricechallenge.model.adapter;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.herokuapp.infopricechallenge.model.dto.v1.CidadeDTO;
import com.herokuapp.infopricechallenge.model.entity.Cidade;
import com.herokuapp.infopricechallenge.template.CommonTemplateLoader;
import com.herokuapp.infopricechallenge.template.dto.CidadeDTOTemplateLoader;
import com.herokuapp.infopricechallenge.template.entity.CidadeTemplateLoader;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class CidadeAdapterTest {
    private Cidade entity;
    private CidadeDTO dto;
    private Cidade entityConvert;
    private CidadeDTO dtoConvert;
    
    @BeforeClass
    public static void loadTemplates() {
        FixtureFactoryLoader.loadTemplates(CommonTemplateLoader.FIXTURE_FACTORY_BASE_PACKAGE);
    }
    
    @Before
    public void setup() {
        entity = Fixture.from(Cidade.class).gimme(CidadeTemplateLoader.RULE_VALID);
        dtoConvert = CidadeAdapter.toDTO(entity);
        dto = Fixture.from(CidadeDTO.class).gimme(CidadeDTOTemplateLoader.RULE_VALID);
        entityConvert = CidadeAdapter.toEntity(dto);
    }
    
    @Test
    public void entityToDTO() {
        assertThat(dto.getId(), equalTo(entityConvert.getId()));
        assertThat(dto.getNome(), equalTo(entityConvert.getNome()));
        assertThat(dto.getEstado(), equalTo(entityConvert.getEstado()));
    }
    
    @Test
    public void DTOToEntity() {
        assertThat(entity.getId(), equalTo(dtoConvert.getId()));
        assertThat(entity.getNome(), equalTo(dtoConvert.getNome()));
        assertThat(entity.getEstado(), equalTo(dtoConvert.getEstado()));
    }
    
    @Test
    public void entityNull() {
        CidadeDTO dto = null;
        Cidade entity = CidadeAdapter.toEntity(dto);
        assertNull(entity);
    }
    
    @Test
    public void dtoNull() {
        Cidade entity = null;
        CidadeDTO dto = CidadeAdapter.toDTO(entity);
        assertNull(dto);
    }
}