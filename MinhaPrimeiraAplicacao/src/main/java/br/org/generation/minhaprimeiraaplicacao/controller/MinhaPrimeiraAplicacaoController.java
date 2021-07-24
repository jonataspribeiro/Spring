package br.org.generation.minhaprimeiraaplicacao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/primeiraaplicacao")
public class MinhaPrimeiraAplicacaoController {

	@GetMapping
	public String primeiraAplicacao() {
		return "Para realizar essa atividade foram utilizadas a mentalidade de persistência "
				+ "e a habilidade de atenção aos detalhes.";
	}
	
}
