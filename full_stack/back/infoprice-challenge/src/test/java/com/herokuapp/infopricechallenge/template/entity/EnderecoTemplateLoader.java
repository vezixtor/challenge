package com.herokuapp.infopricechallenge.template.entity;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import com.herokuapp.infopricechallenge.template.CommonTemplateLoader;
import com.herokuapp.infopricechallenge.model.entity.Endereco;
import static org.apache.commons.lang.math.NumberUtils.*;
import com.herokuapp.infopricechallenge.model.entity.Pessoa;
import com.herokuapp.infopricechallenge.model.entity.Cidade;

public class EnderecoTemplateLoader implements CommonTemplateLoader {

    @Override
    public void load() {
        Fixture.of(Endereco.class).addTemplate(RULE_VALID, new Rule(){{
            add("id", uniqueRandom(LONG_ONE, Long.MAX_VALUE));
            add("pessoa", one(Pessoa.class, RULE_VALID));
            add("logradouro", random(RANDOM_STRINGS));
            add("numero", random(RANDOM_STRINGS));
            add("complemento", random(RANDOM_STRINGS));
            add("bairro", random(RANDOM_STRINGS));
            add("cidade", one(Cidade.class, RULE_VALID));
            add("cep", random(RANDOM_STRINGS));
        }}).addTemplate(RULE_VALID_WITHOUT_ID).inherits(RULE_VALID, new Rule() {{
            add("id", null);
        }}).addTemplate(RULE_VALID_WITHOUT_FK).inherits(RULE_VALID_WITHOUT_ID, new Rule() {{
        }}).addTemplate(RULE_INVALID, new Rule(){{
        }});
    }
}
