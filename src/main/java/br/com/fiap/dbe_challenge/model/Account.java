package br.com.fiap.dbe_challenge.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Account {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Nome inválido. (Você deve ter um nome)")
	private String nome;
	
	@Size(message = "Região inválida. (Informe sua região; Ex: SP, RJ, MG...)", min=2, max=2)
	private String regiao;
	
	@Size(message = "CPF inválido. (Apenas 11 números)", min=11, max=11)
	@Positive
	private String cpf ;
	
}

