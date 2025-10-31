package com.senai.musicapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.musicapi.entities.Artista;
import com.senai.musicapi.repositories.ArtistaRepository;

@Service
public class ArtistaService {

	@Autowired
	private ArtistaRepository repository;

	// Salvar
	public Artista salvarArtista(Artista artista) {
		return repository.save(artista);
	}

	// Listar
	public List<Artista> listarArtista() {
		return repository.findAll();
	}

	// Buscar
	public Artista buscarPorId(Long id) {
		return repository.findById(id).orElse(null);
	}

	// Atualizar
	public Artista atualizarArtista(Long id, Artista aNovo) {

		Artista aVelho = repository.findById(id).get();

		aVelho.setNome(aNovo.getNome());
		aVelho.setGeneroMusical(aNovo.getGeneroMusical());
		aVelho.setNacionalidade(aNovo.getNacionalidade());
		aVelho.setAnoEstreia(aNovo.getAnoEstreia());

		return repository.save(aVelho);

	}

	// Deletar
	public void deletarArtista(Long id) {
		Artista artista = buscarPorId(id);
		repository.delete(artista);
	}

}
