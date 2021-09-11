package br.com.fiap.dbe_challenge.controller.advice;

import br.com.fiap.dbe_challenge.controller.advice.ValidationFieldErro;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidationFieldErro {
	
	private String field;
	private String error;

}
