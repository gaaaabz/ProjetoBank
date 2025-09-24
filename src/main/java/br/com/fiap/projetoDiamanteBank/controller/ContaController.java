package br.com.fiap.projetoDiamanteBank.controller;

import java.math.BigDecimal;
import java.util.List;


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


import com.br.fiap.ProjetoBank.model.Conta;
import com.br.fiap.ProjetoBank.service.ContaService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/conta")
@Slf4j
public class ContaController {
 
    private final ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Conta criar(@RequestBody @Valid Conta conta) {
        return contaService.criarConta(conta);
    }

    @GetMapping
    public List<Conta> listar() {
        return contaService.listarContas();
    }

    @GetMapping("/{id}")
    public Conta buscarPorId(@PathVariable Long id) {
        return contaService.buscarContaPorId(id);
    }

    @PutMapping("/{id}/encerrar")
    public Conta encerrar(@PathVariable Long id) {
        return contaService.encerrarConta(id);
    }

    @PutMapping("/{id}/deposito")
    public Conta depositar(@PathVariable Long id, @RequestParam BigDecimal valor) {
        return contaService.depositar(id, valor);
    }

    @PutMapping("/{id}/saque")
    public Conta sacar(@PathVariable Long id, @RequestParam BigDecimal valor) {
        return contaService.sacar(id, valor);
    }

    @PutMapping("/pix")
    public Conta pix(@RequestParam Long idOrigem, @RequestParam Long idDestino, @RequestParam BigDecimal valor) {
        return contaService.transferir(idOrigem, idDestino, valor);
    }
}

