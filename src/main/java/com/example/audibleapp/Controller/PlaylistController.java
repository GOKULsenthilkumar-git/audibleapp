package com.example.audibleapp.Controller;

import com.example.audibleapp.model.Playlist;
import com.example.audibleapp.Service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/playlists")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    // Get all playlists
    @GetMapping
    public List<Playlist> getAllPlaylists() {
        return playlistService.getAllPlaylists();
    }

    // Get a playlist by ID
    @GetMapping("/{id}")
    public ResponseEntity<Playlist> getPlaylistById(@PathVariable int id) {
        return playlistService.getPlaylistById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new playlist
    @PostMapping
    public Playlist createPlaylist(@RequestBody Playlist playlist) {
        return playlistService.createPlaylist(playlist);
    }

    // Update an existing playlist
    @PutMapping("/{id}")
    public ResponseEntity<Playlist> updatePlaylist(@PathVariable int id, @RequestBody Playlist playlistDetails) {
        return ResponseEntity.ok(playlistService.updatePlaylist(id, playlistDetails));
    }

    // Delete a playlist
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlaylist(@PathVariable int id) {
        playlistService.deletePlaylist(id);
        return ResponseEntity.noContent().build();
    }

    // Find playlists by user ID
    @GetMapping("/user/{userId}")
    public List<Playlist> getPlaylistsByUserId(@PathVariable int userId) {
        return playlistService.findByUserId(userId);
    }
}