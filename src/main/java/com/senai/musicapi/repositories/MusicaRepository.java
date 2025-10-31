package com.senai.musicapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.musicapi.entities.Musica;

public interface MusicaRepository extends JpaRepository<Musica, Long> {

}
