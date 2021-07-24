package br.org.generation.minhasegundaaplicacao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/segunda")

public class MinhaSegundaAplicacaoController {

	@GetMapping
	public String segundaAplicacao() {
		return" O objetivo de aprendizagem desta semana é aplicar todo conteúdo passado referente ao Spring e MySQL,"
				+ " para que seja possível atiginir o objetivo de realizar uma aplicação web.";
	}
	
}
