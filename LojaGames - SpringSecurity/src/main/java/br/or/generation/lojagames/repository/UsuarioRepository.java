package br.or.generation.lojagames.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.lojagames.model.Usuario;

//Interface não implementa nada, é obrigatório inserir todos os métodos

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{ //Usuario: Classe / Long: Chave Primária

	public Optional<Usuario> findByUsuario(String usuario); //find:select By:where --> select * from tb_usuarios where usuario = "xxx"; 
	//Optional: Caso não seja encontrado na Classe, está função elimina o erro.
	
	
	
	
}
