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

import com.senai.musicapi.entities.Musica;
import com.senai.musicapi.services.MusicaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/musica")
public class MusicaController {

	@Autowired // instanciação automática do objeto
	private MusicaService service;

	// Cadastrar Musica
	@PostMapping
	public Musica cadastrarMusica(@Valid @RequestBody Musica musica) {
		return service.salvarMusica(musica);
	}

	// Listar Musica
	@GetMapping
	public List<Musica> listarTodos() {
		return service.listarMusica();
	}

	// Atualizar Musica
	@PutMapping("/{id}")
	public Musica atualizarMusica(@PathVariable Long id, @RequestBody Musica musica) {
		return service.atualizarMusica(id, musica);
	}

	// Buscar Musica
	@GetMapping("/{id}")
	public Musica buscarPorId(@PathVariable Long id) {
		return service.buscarPorId(id);
	}

	// Deletar Musica
	@DeleteMapping("/{id}")
	public String deletarMusica(@PathVariable Long id) {
		service.deletarMusica(id);
		return "A música com a ID " + id + " foi removida.";

	}

}
