package com.herokuapp.infopricechallenge.model.adapter;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.herokuapp.infopricechallenge.model.dto.v1.EnderecoDTO;
import com.herokuapp.infopricechallenge.model.entity.Endereco;
import com.herokuapp.infopricechallenge.template.CommonTemplateLoader;
import com.herokuapp.infopricechallenge.template.dto.EnderecoDTOTemplateLoader;
import com.herokuapp.infopricechallenge.template.entity.EnderecoTemplateLoader;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class EnderecoAdapterTest {
    private Endereco entity;
    private EnderecoDTO dto;
    private Endereco entityConvert;
    private EnderecoDTO dtoConvert;
    
    @BeforeClass
    public static void loadTemplates() {
        FixtureFactoryLoader.loadTemplates(CommonTemplateLoader.FIXTURE_FACTORY_BASE_PACKAGE);
    }
    
    @Before
    public void setup() {
        entity = Fixture.from(Endereco.class).gimme(EnderecoTemplateLoader.RULE_VALID);
        dtoConvert = EnderecoAdapter.toDTO(entity);
        dto = Fixture.from(EnderecoDTO.class).gimme(EnderecoDTOTemplateLoader.RULE_VALID);
        entityConvert = EnderecoAdapter.toEntity(dto);
    }
    
    @Test
    public void entityToDTO() {
        assertThat(dto.getId(), equalTo(entityConvert.getId()));
        assertThat(dto.getPessoa().hashCode(), equalTo(entityConvert.getPessoa().hashCode()));
        assertThat(dto.getLogradouro(), equalTo(entityConvert.getLogradouro()));
        assertThat(dto.getNumero(), equalTo(entityConvert.getNumero()));
        assertThat(dto.getComplemento(), equalTo(entityConvert.getComplemento()));
        assertThat(dto.getBairro(), equalTo(entityConvert.getBairro()));
        assertThat(dto.getCidade().hashCode(), equalTo(entityConvert.getCidade().hashCode()));
        assertThat(dto.getCep(), equalTo(entityConvert.getCep()));
    }
    
    @Test
    public void DTOToEntity() {
        assertThat(entity.getId(), equalTo(dtoConvert.getId()));
        assertThat(entity.getPessoa().hashCode(), equalTo(dtoConvert.getPessoa().hashCode()));
        assertThat(entity.getLogradouro(), equalTo(dtoConvert.getLogradouro()));
        assertThat(entity.getNumero(), equalTo(dtoConvert.getNumero()));
        assertThat(entity.getComplemento(), equalTo(dtoConvert.getComplemento()));
        assertThat(entity.getBairro(), equalTo(dtoConvert.getBairro()));
        assertThat(entity.getCidade().hashCode(), equalTo(dtoConvert.getCidade().hashCode()));
        assertThat(entity.getCep(), equalTo(dtoConvert.getCep()));
    }
    
    @Test
    public void entityNull() {
        EnderecoDTO dto = null;
        Endereco entity = EnderecoAdapter.toEntity(dto);
        assertNull(entity);
    }
    
    @Test
    public void dtoNull() {
        Endereco entity = null;
        EnderecoDTO dto = EnderecoAdapter.toDTO(entity);
        assertNull(dto);
    }
}