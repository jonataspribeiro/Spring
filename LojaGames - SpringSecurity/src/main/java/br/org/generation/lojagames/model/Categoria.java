package br.org.generation.lojagames.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity // Inicializar a classe Model - Definir a tabela
@Table(name = "tb_categoria") // @Table = Definir um nome para sua tabela
public class Categoria {

	@Id //Criar o ID
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Gerar o valor AutoIncrement - caso não colcarmos esta opção 
	private long id;

	@NotNull(message = "O atributo tipo não pode ser Nulo!")
	private String tipo;
	
	@OneToMany(mappedBy = "tb_categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("tb_categoria")
	private List<Produto>produto;

	public long getId() {
		return id;
	}

	public List<Produto> getPorduto() {
		return produto;
	}

	public void setPorduto(List<Produto> porduto) {
		this.produto = porduto;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
