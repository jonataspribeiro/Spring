package br.ogr.generation.org.lojagames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.or.generation.lojagames.repository.CategoriaRepository;
import br.org.generation.lojagames.model.Categoria;

@RestController // é uma anotação de conveniência que tem como função adicionar anotações
@RequestMapping("/categoria") // Mapeia o endpoint
@CrossOrigin(origins = "*", allowedHeaders = "*")
/*
 * @CrossOrigin("*"): Annotation (Anotação), que indica que a classe
 * controladora permitirá o recebimento de requisições realizadas de fora do
 * domínio (localhost, em nosso caso) ao qual ela pertence. Essa anotação é
 * essencial para que o front-end (Angular em nosso caso), tenha acesso à nossa
 * API (O termo técnico é consumir a API) Para as versões mais recentes do
 * Angular, recomenda-se alterar esta anotação para:
 * Annotation @CrossOrigin(origins = "*", allowedHeaders = "*") Esta anotação,
 * além de liberar as origens, libera também os cabeçalhos das requisições
 */

public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping
	private ResponseEntity<List<Categoria>> getAll() {// Tipo de objeto que preciso para trazer uma resposta
		return ResponseEntity.ok(categoriaRepository.findAll());
	}

	@GetMapping("/{id}")
	private ResponseEntity<Categoria> getById(@PathVariable long id) {// Tipo de objeto que preciso para trazer uma
																		// resposta - @PathVariable Anotação que indica
																		// que um parâmetro de método deve ser vinculado
																		// a uma variável de modelo URI. Compatível com
																		// métodos de manipulador anotados
																		// RequestMapping.
		return categoriaRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	private ResponseEntity<Categoria> post(@RequestBody Categoria categoria) {// Tipo de objeto que preciso para trazer
																				// uma resposta
		return ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.save(categoria));
	}

	@GetMapping("/tipo/{tipo}")
	public ResponseEntity<List<Categoria>> GetByTipo(@PathVariable String tipo) {

		return ResponseEntity.ok(categoriaRepository.findAllByTipoContainingIgnoreCase(tipo));
	}

	@PutMapping
	private ResponseEntity<Categoria> put(@RequestBody Categoria categoria) {// Tipo de objeto que preciso para trazer
																				// uma resposta
		return ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.save(categoria));
	}

	@DeleteMapping("/{id}")
	public void getId(@PathVariable long id) {
		categoriaRepository.deleteById(id);
	}

}
