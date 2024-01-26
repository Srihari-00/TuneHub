package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Song;

public interface SongRepository extends JpaRepository<Song, Integer>
{
	public Song findByName(String name);
}
