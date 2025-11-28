package com.senai.musicapi.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	@Column(name = "id_album")
	private Long id;

	@NotBlank(message = "O título do álbum é obrigatório.")
	@Size(min = 3, max = 100, message = "O título deve ter entre 3 e 100 caracteres.")
	@Column(name = "titulo_album", length = 100, nullable = false, unique = true)
	private String titulo;

	@NotBlank(message = "O gênero do álbum é obrigatório.")
	@Size(min = 3, max = 100, message = "O gênero do álbum deve ter entre 3 e 100 caracteres.")
	@Column(name = "genero_album", length = 100, nullable = false)
	private String genero;

	@Positive(message = "A quantidade de música deve ser maior que zero.")
//	@NotBlank(message = "A quantidade de músicas é obrigatória.")
	@Column(name = "qtd_musicas", nullable = false)
	private int qtdMusicas;

//	@NotBlank(message = "O ano de lançamento é obrigatório.")
	@Min(value = 2000, message = "O ano de lançamento deve ser maior que 2000.")
	@Max(value = 2030, message = "O ano de lançamento não pode ser maior que 2030.")
	@Column(name = "ano_lancamento", nullable = false)
	private int anoLancamento;

	@JsonManagedReference
	@OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
	private List<Musica> musica;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_artista", nullable = false)
	private Artista artista;

	public Album() {

	}

	public Album(String titulo, String genero, int qtdMusicas, int anoLancamento, Artista artista) {
		this.titulo = titulo;
		this.genero = genero;
		this.qtdMusicas = qtdMusicas;
		this.anoLancamento = anoLancamento;
		this.artista = artista;
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

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

}