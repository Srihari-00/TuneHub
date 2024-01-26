package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Playlist;

public interface PlaylistService 
{
	public void addPlaylist(Playlist playlist);

	public List<Playlist> fetchAllPlaylists();
	
	public Playlist findByName(String name);
}
