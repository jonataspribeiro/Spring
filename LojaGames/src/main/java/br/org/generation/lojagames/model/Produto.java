package br.org.generation.lojagames.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity // Inicializar a classe Model - Definir a tabela
@Table(name = "tb_produtos") // @Table = Definir um nome para sua tabela
public class Produto {

	@Id //Criar o ID
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Gerar o valor AutoIncrement - caso não colcarmos esta opção 
	private long id;

	@NotNull(message = "O campo título é  obrigatório!")
	@Size(min = 3, max = 250, message = "o campo titulo deve conter no minimo 5 e no máximo 250 caracteres." )
	private String titulo;
	
	@NotNull(message = "O campo codigo é  obrigatório!")
	@Size(min = 1, max = 20, message = "O campo codigo deve conter no mínimo 7 e no maximo 10 caracteres.")
	private String codigo;
	
	
	@NotNull(message = "O campo quantidade deve ser preenchido.")
	private int quantidade;
	
	@NotNull(message = "O campo valor deve ser prenchido.")
	private BigDecimal valor;
	
	
	//chave FK N:1 - Muitos para um
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;


	
}
