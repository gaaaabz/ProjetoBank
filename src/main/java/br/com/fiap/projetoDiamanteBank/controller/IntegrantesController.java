package br.com.fiap.projetoDiamanteBank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IntegrantesController {
    
    
    @GetMapping("/")
    public String integrantesProjeto() {
        return "Projeto feito indivudualmente por Gabriel Gomes Cardoso RM:559597";
    }
}