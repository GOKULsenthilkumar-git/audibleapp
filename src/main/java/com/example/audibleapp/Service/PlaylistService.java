package com.example.audibleapp.Service;

import com.example.audibleapp.Model.Playlist;
import com.example.audibleapp.Repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@SuppressWarnings("unused") // Suppress the "never used" warning
public class PlaylistService {
    // Service code

    @Autowired
    private PlaylistRepository playlistRepository;

    // Get all playlists
    public List<Playlist> getAllPlaylists() {
        return playlistRepository.findAll();
    }

    // Get a playlist by ID
    public Optional<Playlist> getPlaylistById(int id) {
        return playlistRepository.findById(id);
    }

    // Create a new playlist
    public Playlist createPlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    // Update an existing playlist
    public Playlist updatePlaylist(int id, Playlist playlistDetails) {
        Playlist playlist = playlistRepository.findById(id).orElseThrow(() -> new RuntimeException("Playlist not found"));
        playlist.setUserId(playlistDetails.getUserId());
        playlist.setTitle(playlistDetails.getTitle());
        return playlistRepository.save(playlist);
    }

    // Delete a playlist
    public void deletePlaylist(int id) {
        playlistRepository.deleteById(id);
    }

    // Find playlists by user ID
    public List<Playlist> findByUserId(int userId) {
        return playlistRepository.findByUserId(userId);
    }
}