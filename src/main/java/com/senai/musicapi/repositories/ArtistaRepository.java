package com.senai.musicapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.musicapi.entities.Artista;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {

}
