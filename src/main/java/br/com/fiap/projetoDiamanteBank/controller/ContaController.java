package br.com.fiap.projetoDiamanteBank.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.projetoDiamanteBank.Service.ContaService;
import br.com.fiap.projetoDiamanteBank.model.Conta;
import br.com.fiap.projetoDiamanteBank.repository.ContaRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/conta")
@Slf4j
public class ContaController {
 
    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Conta criar(@RequestBody @Valid Conta conta) {
        return contaService.criarConta(conta);
    }

    @GetMapping
    public List<Conta> index() {
        return contaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Conta buscarPorId(@PathVariable Long id) {
        return contaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta não encontrada"));
    }
    
    @PutMapping("/encerrar/{id}")
    public Conta encerrar(@PathVariable Long id) {
        Conta conta = buscarPorId(id);
        conta.setAtivo(false);
        return contaRepository.save(conta);
    }
    
}

