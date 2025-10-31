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

import com.senai.musicapi.entities.Album;
import com.senai.musicapi.services.AlbumService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/album")
public class AlbumController {

	@Autowired
	private AlbumService service;

	// Cadastrar Album
	@PostMapping
	public Album cadastrarArtista(@Valid @RequestBody Album album) {
		return service.salvarAlbum(album);
	}

	// Listar Album
	@GetMapping
	public List<Album> listarAlbum() {
		return service.listarAlbum();
	}

	// Atualizar Album
	@PutMapping("/{id}")
	public Album atualizarAlbum(@PathVariable Long id, @RequestBody Album album) {
		return service.atualizarAlbum(id, album);
	}

	// Buscar Album
	@GetMapping("/{id}")
	public Album buscarPorId(@PathVariable Long id) {
		return service.buscarPorId(id);
	}

	// Deletar Album
	@DeleteMapping("/{id}")
	public String deletarAlbum(@PathVariable Long id) {
		service.deletarAlbum(id);
		return "O álbum com a ID " + id + " foi removido.";
	}

}
