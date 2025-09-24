package br.com.fiap.projetoDiamanteBank.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Conta {

   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{conta.numero.notblank}")
    private String numero;

    @NotBlank(message = "{conta.agencia.notblank}")
    private String agencia;

    @NotBlank(message = "{conta.nomeTitular.notblank}")
    private String nome;

    @NotBlank(message = "{conta.cpfTitular.notblank}")
    @Pattern(regexp = "\\d{11}", message = "{conta.cpfTitular.size}")
    private String cpf;

    @PastOrPresent(message = "{conta.dataAbertura.pastorpresent}")
    private LocalDate dataAbertura;

    @NotNull(message = "{conta.saldo.notnull}")
    @Positive(message = "{conta.saldo.positive}")
    private BigDecimal saldo;

    private Boolean ativo;

    @NotNull(message = "{conta.tipo.notnull}")
    private TipoConta tipo;
}
