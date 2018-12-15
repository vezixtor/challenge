package com.herokuapp.infopricechallenge.template.dto;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import com.herokuapp.infopricechallenge.template.CommonTemplateLoader;
import com.herokuapp.infopricechallenge.model.dto.v1.EnderecoDTO;
import static org.apache.commons.lang.math.NumberUtils.*;
import com.herokuapp.infopricechallenge.model.dto.v1.PessoaDTO;
import com.herokuapp.infopricechallenge.model.dto.v1.CidadeDTO;

public class EnderecoDTOTemplateLoader implements CommonTemplateLoader {

    @Override
    public void load() {
        Fixture.of(EnderecoDTO.class).addTemplate(RULE_VALID, new Rule(){{
            add("id", random(Long.class, range(LONG_ONE, Long.MAX_VALUE)));
            add("pessoa", one(PessoaDTO.class, RULE_VALID));
            add("logradouro", random(RANDOM_STRINGS));
            add("numero", random(RANDOM_STRINGS));
            add("complemento", random(RANDOM_STRINGS));
            add("bairro", random(RANDOM_STRINGS));
            add("cidade", one(CidadeDTO.class, RULE_VALID));
            add("cep", random(RANDOM_STRINGS));
        }}).addTemplate(RULE_INVALID, new Rule(){{
        }});
    }
}
