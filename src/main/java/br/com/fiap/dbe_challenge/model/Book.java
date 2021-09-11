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
public class Book {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Titulo inválido. (O livro deve ter um titulo)")
	private String titulo;
	
	@NotBlank(message = "Autor inválido. (O livro deve ter um autor)")
	private String autor;
	
	@NotBlank(message = "Autor inválido. (O livro deve ter um autor)")
	private String genero;
	
	@Size(message = "Valor inválida. (Mínimo de 2 caracteres)", min=1)
	@Positive
	private String valor;
	
	

}
