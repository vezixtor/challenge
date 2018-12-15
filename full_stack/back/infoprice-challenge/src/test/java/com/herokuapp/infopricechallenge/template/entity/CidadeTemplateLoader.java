package com.herokuapp.infopricechallenge.template.entity;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import com.herokuapp.infopricechallenge.template.CommonTemplateLoader;
import com.herokuapp.infopricechallenge.model.entity.Cidade;
import static org.apache.commons.lang.math.NumberUtils.*;
import com.herokuapp.infopricechallenge.model.type.Estado;

public class CidadeTemplateLoader implements CommonTemplateLoader {

    @Override
    public void load() {
        Fixture.of(Cidade.class).addTemplate(RULE_VALID, new Rule(){{
            add("id", uniqueRandom(LONG_ONE, Long.MAX_VALUE));
            add("nome", random(RANDOM_STRINGS));
            add("estado", random(Estado.class));
        }}).addTemplate(RULE_VALID_WITHOUT_ID).inherits(RULE_VALID, new Rule() {{
            add("id", null);
        }}).addTemplate(RULE_VALID_WITHOUT_FK).inherits(RULE_VALID_WITHOUT_ID, new Rule() {{
        }}).addTemplate(RULE_INVALID, new Rule(){{
        }});
    }
}
