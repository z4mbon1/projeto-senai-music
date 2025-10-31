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
@Table(name = "tb_musica")
public class Musica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O título da música é obrigatório.")
	@Size(min = 3, max = 100, message = "O titulo da música deve ter entre 3 e 100 caracteres.")
	@Column(name = "titulo_musica", unique = true)
	private String titulo;

	@NotBlank(message = "O gênero é obrigatório.")
	@Size(min = 3, max = 100, message = "O gênero deve ter entre 3 e 100 caracteres.")
	@Column(name = "genero")
	private String genero;

	@NotBlank(message = "A duração é obrigatória.")
	@Positive(message = "A duração da música deve ser maior que zero.")
	@Column(name = "duracao")
	private String duracao;

	//@NotBlank(message = "O ano de lançamento é obrigatório.")
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

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

}
