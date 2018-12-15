package com.herokuapp.infopricechallenge.controller;

import com.herokuapp.infopricechallenge.model.dto.ListResultDTO;
import com.herokuapp.infopricechallenge.model.dto.PageDTO;
import com.herokuapp.infopricechallenge.model.dto.v1.CidadeDTO;
import com.herokuapp.infopricechallenge.service.CidadeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "/v1/cidade")
@Api(value = "CidadeControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE, tags = "Cidade")
public class CidadeController {
    private static final String RECURSO = "Cidade";

    @Autowired
    private CidadeService service;

    @GetMapping
    @ApiOperation("Retorna uma lista de registros com paginação")
    public ListResultDTO<CidadeDTO> findAll(CidadeDTO dto, PageDTO page) {
        log.debug("Listar todos {} ", RECURSO);
        return this.service.findAll(dto, page);
    }

    @GetMapping("{id}")
    @ApiOperation("Retorna o registro do ID/PK informado")
    public CidadeDTO findOne(@PathVariable Long id) {
        log.debug("Encontra um registro de {} ", RECURSO);
        return this.service.findOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Cadastra um novo registro")
    public CidadeDTO save(@Validated @RequestBody CidadeDTO dto) {
        log.debug("Cadastrar {}", RECURSO);
        return this.service.save(dto);
    }

    @PutMapping("{id}")
    @ApiOperation("Realiza alterações no registro do ID/PK informado")
    public CidadeDTO update(@PathVariable Long id, @Validated @RequestBody CidadeDTO dto) {
        log.debug("Atualizar {} ", RECURSO);
        return this.service.update(id, dto);
    }

    @DeleteMapping("{id}")
    @ApiOperation("Exclui um registro com base no ID/PK indicado")
    public void delete(@PathVariable Long id) {
        log.debug("Deletando dado {} ", RECURSO);
        this.service.delete(id);
    }
}