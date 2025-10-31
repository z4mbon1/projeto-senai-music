package com.senai.musicapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.musicapi.entities.Album;

public interface AlbumRepository extends JpaRepository<Album, Long> {

}
