package com.example.audibleapp.repository;

import com.example.audibleapp.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {
    // Custom query to find playlists by user ID
    List<Playlist> findByUserId(int userId);
}