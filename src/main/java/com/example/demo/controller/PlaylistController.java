package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Playlist;
import com.example.demo.entity.Song;
import com.example.demo.services.PlaylistService;
import com.example.demo.services.SongService;


@Controller
public class PlaylistController 
{
	@Autowired
	PlaylistService playlistService;

	@Autowired
	SongService songService;

	@GetMapping("/createPlaylist")
	public String createPlaylist(Model model) 
	{
		List<Song> songList = songService.fetchAllSongs();
		model.addAttribute("songs", songList);
		return "createPlaylist";
	}
	@PostMapping("/addPlaylist")
	public String addPlaylist(@ModelAttribute Playlist playlist)
	{
		if(playlistService.findByName(playlist.getName()) == null)
		{
			//Updating the playlist table
			playlistService.addPlaylist(playlist);	
			
			//updating the song table
			if(playlist.getSong() == null) 
			{
				List<Song> songList = playlist.getSong();
				
				for(Song song : songList)
				{
					song.getPlaylist().add(playlist);
					//Update Song Object in the Database
					songService.updateSong(song);
				}	
				System.out.println("Playlist Created");	
				
			}
					
		}
		else {
			System.out.println("Playlist already exists");
		}
		
		return "adminHome";
	}
	
	@GetMapping("/viewPlaylists")
	public String viewPlaylists(Model model) 
	{
		List<Playlist> allPlaylists = playlistService.fetchAllPlaylists();
		model.addAttribute("allPlaylists", allPlaylists);
		System.out.println(allPlaylists);
		return "displayPlaylists";
	}
	
}
