package com.senai.musicapi.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.senai.musicapi.enums.GeneroMusical;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	@Column(name = "id_artista")
	private Long id;

	@NotBlank(message = "O nome é obrigatório.")
	@Size(min = 3, max = 100, message = "O nome do artista deve ter entre 3 e 100 caracteres.")
	@Column(name = "nome_artista", length = 100, nullable = false, unique = true)
	private String nome;

	@NotBlank(message = "O gênero é obrigatório.")
	@Size(min = 3, max = 100, message = "O gênero deve ter entre 3 e 100 caracteres.")
	@Column(name = "genero", nullable = false, length = 100)
	@Enumerated(EnumType.STRING)
	private GeneroMusical genero;

	// @NotBlank(message = "O ano de estreia é obrigatório.")
	@Min(value = 2000, message = "O ano de estreia deve ser maior que 2000.")
	@Max(value = 2030, message = "O ano de estreia não pode ser maior que 2030.")
	@Column(name = "ano_estreia", nullable = false)
	private int anoEstreia;

	@NotBlank(message = "A nacionalidade é obrigatória.")
	@Column(name = "nacionalidade", nullable = false, length = 100)
	private String nacionalidade;

	@JsonManagedReference
	@OneToMany(mappedBy = "artista", cascade = CascadeType.ALL)
	private List<Album> album;

	public Artista() {

	}

	public Artista(String nome, GeneroMusical genero, int anoEstreia, String nacionalidade) {
		this.nome = nome;
		this.genero = genero;
		this.anoEstreia = anoEstreia;
		this.nacionalidade = nacionalidade;
	}

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

	public GeneroMusical getGenero() {
		return genero;
	}

	public void setGenero(GeneroMusical genero) {
		this.genero = genero;
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

	public List<Album> getAlbum() {
		return album;
	}

	public void setAlbum(List<Album> album) {
		this.album = album;
	}
}