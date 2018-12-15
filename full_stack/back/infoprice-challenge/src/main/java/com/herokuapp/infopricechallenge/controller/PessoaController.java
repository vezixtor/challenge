package com.herokuapp.infopricechallenge.controller;

import com.herokuapp.infopricechallenge.model.dto.ListResultDTO;
import com.herokuapp.infopricechallenge.model.dto.PageDTO;
import com.herokuapp.infopricechallenge.model.dto.v1.PessoaDTO;
import com.herokuapp.infopricechallenge.service.PessoaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/v1/pessoa")
@Api(value = "PessoaControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE, tags = "Pessoa")
public class PessoaController {
    private static final String RECURSO = "Pessoa";
    
    @Autowired
    private PessoaService service;
    
    @GetMapping
    @ApiOperation("Retorna uma lista de registros com paginação")
    public ListResultDTO<PessoaDTO> findAll(PessoaDTO dto, PageDTO page) {
        log.debug("Listar todos {} ", RECURSO);
        return this.service.findAll(dto, page);
    }
    
    @GetMapping("{id}")
    @ApiOperation("Retorna o registro do ID/PK informado")
    public PessoaDTO findOne(@PathVariable Long id) {
        log.debug("Encontra um registro de {} ", RECURSO);
        return this.service.findOne(id);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Cadastra um novo registro")
    public PessoaDTO save(@Validated @RequestBody PessoaDTO dto) {
        log.debug("Cadastrar {}", RECURSO);
        return this.service.save(dto);
    }
    
    @PutMapping("{id}")
    @ApiOperation("Realiza alterações no registro do ID/PK informado")
    public PessoaDTO update(@PathVariable Long id, @Validated @RequestBody PessoaDTO dto) {
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