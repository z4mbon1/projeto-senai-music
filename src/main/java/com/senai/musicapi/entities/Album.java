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
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_album")
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O título do álbum é obrigatório.")
	@Size(min = 3, max = 100, message = "O título deve ter entre 3 e 100 caracteres.")
	@Column(name = "titulo_album", unique = true)
	private String titulo;

	@NotBlank(message = "O gênero do álbum é obrigatório.")
	@Size(min = 3, max = 100, message = "O gênero do álbum deve ter entre 3 e 100 caracteres.")
	@Column(name = "genero_album")
	private String genero;

	@Positive(message = "A quantidade de música deve ser maior que zero.")
//	@NotBlank(message = "A quantidade de músicas é obrigatória.")
	@Column(name = "qtd_musicas")
	private int qtdMusicas;

//	@NotBlank(message = "O ano de lançamento é obrigatório.")
	@Min(value = 2000, message = "O ano de lançamento deve ser maior que 2000.")
	@Max(value = 2030, message = "O ano de lançamento não pode ser maior que 2030.")
	@Column(name = "ano_lancamento")
	private int anoLancamento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getQtdMusicas() {
		return qtdMusicas;
	}

	public void setQtdMusicas(int qtdMusicas) {
		this.qtdMusicas = qtdMusicas;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

}