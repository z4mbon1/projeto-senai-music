package com.senai.musicapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.musicapi.entities.Musica;
import com.senai.musicapi.repositories.MusicaRepository;

@Service
public class MusicaService {

	@Autowired
	private MusicaRepository repository;

	// Salvar
	public Musica salvarMusica(Musica musica) {
		return repository.save(musica);
	}

	// Listar
	public List<Musica> listarMusica() {
		return repository.findAll();
	}

	// Buscar
	public Musica buscarPorId(Long id) {
		return repository.findById(id).orElse(null);
	}

	// Atualizar
	public Musica atualizarMusica(Long id, Musica cNovo) {

		Musica cVelho = repository.findById(id).get();

		cVelho.setTitulo(cNovo.getTitulo());
		cVelho.setGenero(cNovo.getGenero());
		cVelho.setDuracao(cNovo.getDuracao());
		cVelho.setAnoLancamento(cNovo.getAnoLancamento());

		return repository.save(cVelho);

	}

	// Deletar
	public void deletarMusica(Long id) {
		Musica musica = buscarPorId(id);
		repository.delete(musica);

	}

}
