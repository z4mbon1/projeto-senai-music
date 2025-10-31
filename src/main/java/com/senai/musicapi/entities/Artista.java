package com.senai.musicapi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_artista")
public class Artista {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O nome é obrigatório.")
	@Size(min = 3, max = 100, message = "O nome do artista deve ter entre 3 e 100 caracteres.")
	@Column(name = "nome_artista", unique = true)
	private String nome;

	@NotBlank(message = "O gênero musical é obrigatório.")
	@Size(min = 3, max = 100, message = "O gênero musical deve ter entre 3 e 100 caracteres.")
	@Column(name = "genero_musical")
	private String generoMusical;

	//@NotBlank(message = "O ano de estreia é obrigatório.")
	@Min(value = 2000, message = "O ano de estreia deve ser maior que 2000.")
	@Max(value = 2030, message = "O ano de estreia não pode ser maior que 2030.")
	@Column(name = "ano_estreia")
	private int anoEstreia;

	@NotBlank(message = "A nacionalidade é obrigatória.")
	@Column(name = "nacionalidade")
	private String nacionalidade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGeneroMusical() {
		return generoMusical;
	}

	public void setGeneroMusical(String generoMusical) {
		this.generoMusical = generoMusical;
	}

	public int getAnoEstreia() {
		return anoEstreia;
	}

	public void setAnoEstreia(int anoEstreia) {
		this.anoEstreia = anoEstreia;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
}
