package com.example.audibleapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "playlist")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playlist_ID")
    private int playlistId;

    @Column(name = "user_ID", nullable = false)
    private int userId;

    @Column(name = "title", nullable = false)
    private String title;

    // Constructors
    public Playlist() {
    }

    public Playlist(int userId, String title) {
        this.userId = userId;
        this.title = title;
    }

    // Getters and Setters
    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "playlistId=" + playlistId +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                '}';
    }
}