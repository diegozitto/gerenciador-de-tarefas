package com.gerenciador_de_tarefas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 Anotação "@RestController" para ser considerado api
 Anotação "@GetMapping" para poder definir o endereço do teste
  */

@RestController
public class TesteApiController {

    @GetMapping("/teste-api")
    private String teste(){
        return "Sucesso";
    }
}
