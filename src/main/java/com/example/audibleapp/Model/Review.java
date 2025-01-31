package com.example.audibleapp.Model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_ID")
    private int reviewId;

    @Column(name = "user_ID", nullable = false)
    private int userId;

    @Column(name = "audiocast_ID", nullable = false)
    private int audiocastId;

    @Column(name = "comment")
    private String comment;

    @Column(name = "reviewdate", nullable = false)
    private Date reviewDate;

    @Column(name = "rating", nullable = false)
    private float rating;

    // Constructors
    public Review() {
    }

    public Review(int userId, int audiocastId, String comment, Date reviewDate, float rating) {
        this.userId = userId;
        this.audiocastId = audiocastId;
        this.comment = comment;
        this.reviewDate = reviewDate;
        this.rating = rating;
    }

    // Getters and Setters
    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAudiocastId() {
        return audiocastId;
    }

    public void setAudiocastId(int audiocastId) {
        this.audiocastId = audiocastId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", userId=" + userId +
                ", audiocastId=" + audiocastId +
                ", comment='" + comment + '\'' +
                ", reviewDate=" + reviewDate +
                ", rating=" + rating +
                '}';
    }
}