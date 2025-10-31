package com.senai.musicapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.musicapi.entities.Album;
import com.senai.musicapi.repositories.AlbumRepository;

@Service
public class AlbumService {

	@Autowired
	private AlbumRepository repository;

	// Salvar
	public Album salvarAlbum(Album album) {
		return repository.save(album);
	}

	// Listar
	public List<Album> listarAlbum() {
		return repository.findAll();
	}

	// Buscar
	public Album buscarPorId(Long id) {
		return repository.findById(id).orElse(null);
	}

	// Atualizar
	public Album atualizarAlbum(Long id, Album aNovo) {

		Album aVelho = repository.findById(id).get();

		aVelho.setTitulo(aNovo.getTitulo());
		aVelho.setGenero(aNovo.getGenero());
		aVelho.setQtdMusicas(aNovo.getQtdMusicas());
		aVelho.setAnoLancamento(aNovo.getAnoLancamento());

		return repository.save(aVelho);

	}

	// Deletar
	public void deletarAlbum(Long id) {
		Album album = buscarPorId(id);
		repository.delete(album);
	}

}
