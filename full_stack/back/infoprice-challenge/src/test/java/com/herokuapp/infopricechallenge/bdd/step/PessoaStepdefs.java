package com.herokuapp.infopricechallenge.bdd.step;

import com.herokuapp.infopricechallenge.bdd.scenario.PessoaScenario;
import com.herokuapp.infopricechallenge.bdd.step.common.FeatureTest;
import com.herokuapp.infopricechallenge.model.adapter.PessoaAdapter;
import com.herokuapp.infopricechallenge.model.dto.v1.PessoaDTO;
import com.herokuapp.infopricechallenge.model.entity.Pessoa;
import cucumber.api.Scenario;
import cucumber.api.java8.En;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class PessoaStepdefs extends FeatureTest implements En {
    private final String ENDPOINT = "/v1/pessoa/";
    private List<Pessoa> entities = new ArrayList<>();
    private List<PessoaDTO> dtos = new ArrayList<>();
    private Response response;
    private PessoaDTO dto;
    
    @Autowired
    private PessoaScenario scenario;
    
    public PessoaStepdefs() {
        Given("^(\\d+) registro\\(s\\) de pessoa preexistente$", (Integer quantity) -> {
            this.entities = scenario.gimmeEntitySaved(quantity);
            this.dtos = PessoaAdapter.toDTO(this.entities);
        });

        When("^consulto a lista de pessoa$", () -> {
            this.response = RestAssured.expect()
                .statusCode(200)
                .body(CONTENT_PATH, hasSize(entities.size()))
                .when()
                .get(ENDPOINT);

            List<PessoaDTO> dtos = response.jsonPath().getList(CONTENT_PATH, PessoaDTO.class);
            this.dtos.forEach(dto -> assertThat(dtos, hasItem(dto)));
        });

        When("^tento obter os dados de pessoa pela chave$", () -> {
            this.dto = dtos.get(0);
            Long id = dto.getId();

            this.response = RestAssured.expect()
                .statusCode(200)
                .when()
                .get(ENDPOINT + id);
        });

        When("^tento cadastrar os dados de pessoa$", () -> {
            this.dto = scenario.gimmeDTO();

            this.response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(this.dto)
                .expect()
                .statusCode(201)
                .when()
                .post(ENDPOINT);

            PessoaDTO responseDTO = response.getBody().as(PessoaDTO.class);
            assertNotNull(responseDTO);
            this.dto.setId(responseDTO.getId());
        });

        When("^tento alterar os dados de pessoa pela chave$", () -> {
            this.dto = scenario.gimmeDTO();
            Long id = this.dtos.get(0).getId();


            this.response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(this.dto)
                .expect()
                .statusCode(200)
                .when()
                .put(ENDPOINT + id);

            this.dto.setId(id);
        });

        When("^tento deletar o registro de pessoa pela chave$", () -> {
            Long id = this.dtos.get(0).getId();

            RestAssured.expect()
                .statusCode(200)
                .when()
                .delete(ENDPOINT + id);
        });

        Then("^o serviço me retorna a pessoa$", () -> {
            PessoaDTO responseDTO = this.response.getBody().as(PessoaDTO.class);
            assertNotNull(responseDTO);
            assertThat(this.dto, equalTo(responseDTO));
        });

        Then("^o serviço remove o registro de pessoa$", () -> {
            Long id = this.dto.getId();

            RestAssured.given()
                .expect()
                .statusCode(404)
                .when()
                .get(ENDPOINT + id);
        });

        Then("^o serviço me retorna uma lista de pessoa$", () -> {
            List<PessoaDTO> dtos = this.response.jsonPath().getList(CONTENT_PATH, PessoaDTO.class);
            this.dtos.forEach(dto -> assertThat(dtos, hasItem(dto))); 
        });

        After(new String[]{"@Pessoa"}, (Scenario scenario) -> {
            this.scenario.deleteAll();
            assertTrue(this.scenario.isClean());
        });
    }
}