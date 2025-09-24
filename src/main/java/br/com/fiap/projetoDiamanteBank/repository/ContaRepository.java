package br.com.fiap.projetoDiamanteBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.projetoDiamanteBank.model.Conta;


public interface ContaRepository extends JpaRepository<Conta, Long>{
    
}