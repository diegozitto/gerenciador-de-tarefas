package com.gerenciador_de_tarefas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 Anotação "@RestController" para ser considerado api
 Anotação "@GetMapping" para poder definir o endereço do teste e o tipo de verbo HTTP que será utilizado:
 -GetMapping  = Get
 -PostMapping = Post

 Anotação (@RequestParam(name = "nome")String nome), ao usar essa anotação estamos dizendo que ao executar o teste de
 api é necessário passar um parâmetro no Postman cuja a "key" precisa se chamar "nome" e nesse o caso o seu valor será
 o nome do usuário testando, o dado é setado como sendo do tipo String.
  */

@RestController
public class TesteApiController {

    @GetMapping("/teste-api")
    private String teste(){return "Sucesso";}

    @GetMapping("/teste-api-bem-vindo")
    private String testeBemVindo(@RequestParam(name = "nome") String nome){
        return "Olá " + nome + ", seja muito bem vindo!";}
}
