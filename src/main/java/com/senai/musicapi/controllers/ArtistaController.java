package com.senai.musicapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.musicapi.entities.Artista;
import com.senai.musicapi.services.ArtistaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/artista")
public class ArtistaController {

	@Autowired // instanciação automática do objeto
	private ArtistaService service;

	// Cadastrar Artista
	@PostMapping
	public Artista cadastrarArtista(@Valid @RequestBody Artista artista) {
		return service.salvarArtista(artista);
	}

	// Listar Artista
	@GetMapping
	public List<Artista> listarArtista() {
		return service.listarArtista();
	}

	// Atualizar Artista
	@PutMapping("/{id}")
	public Artista atualizarArtista(@PathVariable Long id, @RequestBody Artista artista) {
		return service.atualizarArtista(id, artista);
	}

	// Buscar Artista
	@GetMapping("/{id}")
	public Artista buscarPorId(@PathVariable Long id) {
		return service.buscarPorId(id);
	}

	// Deletar Artista
	@DeleteMapping("/{id}")
	public String deletarArtista(@PathVariable Long id) {
		service.deletarArtista(id);
		return "O artista com a ID " + id + " foi removido.";
	}
}
