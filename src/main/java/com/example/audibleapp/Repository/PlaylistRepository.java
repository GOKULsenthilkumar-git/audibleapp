package com.example.audibleapp.Repository;

import com.example.audibleapp.Model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {
    // Custom query to find playlists by user ID
    List<Playlist> findByUserId(int userId);
}