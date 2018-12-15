package com.herokuapp.infopricechallenge.controller;

import com.herokuapp.infopricechallenge.model.dto.ListResultDTO;
import com.herokuapp.infopricechallenge.model.dto.PageDTO;
import com.herokuapp.infopricechallenge.model.dto.v1.EnderecoDTO;
import com.herokuapp.infopricechallenge.service.EnderecoService;
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
@RequestMapping(path = "/v1/endereco")
@Api(value = "EnderecoControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE, tags = "Endereco")
public class EnderecoController {
    private static final String RECURSO = "Endereco";
    
    @Autowired
    private EnderecoService service;
    
    @GetMapping
    @ApiOperation("Retorna uma lista de registros com paginação")
    public ListResultDTO<EnderecoDTO> findAll(EnderecoDTO dto, PageDTO page) {
        log.debug("Listar todos {} ", RECURSO);
        return this.service.findAll(dto, page);
    }
    
    @GetMapping("{id}")
    @ApiOperation("Retorna o registro do ID/PK informado")
    public EnderecoDTO findOne(@PathVariable Long id) {
        log.debug("Encontra um registro de {} ", RECURSO);
        return this.service.findOne(id);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Cadastra um novo registro")
    public EnderecoDTO save(@Validated @RequestBody EnderecoDTO dto) {
        log.debug("Cadastrar {}", RECURSO);
        return this.service.save(dto);
    }
    
    @PutMapping("{id}")
    @ApiOperation("Realiza alterações no registro do ID/PK informado")
    public EnderecoDTO update(@PathVariable Long id, @Validated @RequestBody EnderecoDTO dto) {
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