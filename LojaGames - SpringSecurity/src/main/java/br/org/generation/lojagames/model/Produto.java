package br.org.generation.lojagames.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity // Inicializar a classe Model - Definir a tabela
@Table(name = "tb_produtos") // @Table = Definir um nome para sua tabela
public class Produto {

	@Id // Criar o ID
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Gerar o valor AutoIncrement - caso não colcarmos esta opção
	private long id;

	@NotNull(message = "O campo nome é  obrigatório!")
	@Size(min = 3, max = 250, message = "o campo titulo deve conter no minimo 5 e no máximo 250 caracteres.")
	private String nome;

	@NotNull(message = "O campo código é  obrigatório!")
	@Size(min = 1, max = 20, message = "O campo codigo deve conter no mínimo 7 e no maximo 10 caracteres.")
	private String codigo;

	@NotNull(message = "O campo quantidade deve ser preenchido.")
	private int quantidade;

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	@NotNull(message = "O campo preço deve ser prenchido.")
	@Positive // Aceita somente valores positivos
	private BigDecimal preco;

	// chave FK N:1 - Muitos para um
	@ManyToOne
	@JsonIgnoreProperties("tb_produtos")
	private Categoria tb_categoria;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Categoria getTb_categoria() {
		return tb_categoria;
	}

	public void setTb_categoria(Categoria tb_categoria) {
		this.tb_categoria = tb_categoria;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValor() {
		return preco;
	}

	public void setValor(BigDecimal valor) {
		this.preco = valor;
	}

}
