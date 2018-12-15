package com.herokuapp.infopricechallenge.template.dto;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import com.herokuapp.infopricechallenge.template.CommonTemplateLoader;
import com.herokuapp.infopricechallenge.model.dto.v1.PessoaDTO;
import static org.apache.commons.lang.math.NumberUtils.*;
import com.herokuapp.infopricechallenge.model.dto.v1.EnderecoDTO;

public class PessoaDTOTemplateLoader implements CommonTemplateLoader {

    @Override
    public void load() {
        Fixture.of(PessoaDTO.class).addTemplate(RULE_VALID, new Rule(){{
            add("id", random(Long.class, range(LONG_ONE, Long.MAX_VALUE)));
            add("nome", random(RANDOM_STRINGS));
            add("email", random(RANDOM_STRINGS));
            add("enderecos", has(3).of(EnderecoDTO.class, RULE_VALID));
        }}).addTemplate(RULE_INVALID, new Rule(){{
        }});
    }
}
