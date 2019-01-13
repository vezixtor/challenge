package com.herokuapp.infopricechallenge.controller;

import com.herokuapp.infopricechallenge.model.type.Estado;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/v1/estado")
@Api(value = "EstadoControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE, tags = "Estado")
public class EstadoController {
    private static final String RECURSO = "Estado";

    @GetMapping
    @ApiOperation("Retorna uma lista de estados")
    public ResponseEntity<Estado[]> findEstades() {
        log.debug("Listar todos {} ", RECURSO);
        return ResponseEntity.ok(Estado.values());
    }
}