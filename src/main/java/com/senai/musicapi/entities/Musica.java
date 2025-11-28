package com.senai.musicapi.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.senai.musicapi.enums.GeneroMusical;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	@Column(name = "id_musica")
	private Long id;

	@NotBlank(message = "O título da música é obrigatório.")
	@Size(min = 3, max = 100, message = "O titulo da música deve ter entre 3 e 100 caracteres.")
	@Column(name = "titulo_musica", length = 100, nullable = false, unique = true)
	private String titulo;

	@NotBlank(message = "O gênero é obrigatório.")
	@Size(min = 3, max = 100, message = "O gênero deve ter entre 3 e 100 caracteres.")
	@Column(name = "genero", length = 100, nullable = false)
	@Enumerated(EnumType.STRING)
	private GeneroMusical genero;

	@NotBlank(message = "A duração é obrigatória.")
	@Positive(message = "A duração da música deve ser maior que zero.")
	@Column(name = "duracao", nullable = false)
	private String duracao;

	@NotBlank(message = "O ano de lançamento é obrigatório.")
	@Min(value = 2000, message = "O ano de lançamento deve ser maior que 2000.")
	@Max(value = 2030, message = "O ano de lançamento não pode ser maior que 2030.")
	@Column(name = "ano_lancamento", nullable = false)
	private int anoLancamento;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_album", nullable = false)
	private Album album;

	public Musica() {

	}

	public Musica(String titulo, GeneroMusical genero, String duracao, int anoLancamento, Album album) {
		this.titulo = titulo;
		this.genero = genero;
		this.duracao = duracao;
		this.anoLancamento = anoLancamento;
		this.album = album;
	}

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

	public GeneroMusical getGenero() {
		return genero;
	}

	public void setGenero(GeneroMusical genero) {
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

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
}