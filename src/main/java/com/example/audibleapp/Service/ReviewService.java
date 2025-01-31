package com.example.audibleapp.Service;

import com.example.audibleapp.Model.Review;
import com.example.audibleapp.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    // Get all reviews
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    // Get a review by ID
    public Optional<Review> getReviewById(int id) {
        return reviewRepository.findById(id);
    }

    // Create a new review
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    // Update an existing review
    public Review updateReview(int id, Review reviewDetails) {
        Review review = reviewRepository.findById(id).orElseThrow(() -> new RuntimeException("Review not found"));
        review.setUserId(reviewDetails.getUserId());
        review.setAudiocastId(reviewDetails.getAudiocastId());
        review.setComment(reviewDetails.getComment());
        review.setReviewDate(reviewDetails.getReviewDate());
        review.setRating(reviewDetails.getRating());
        return reviewRepository.save(review);
    }

    // Delete a review
    public void deleteReview(int id) {
        reviewRepository.deleteById(id);
    }

    // Find reviews by audiocast ID
    public List<Review> findByAudiocastId(int audiocastId) {
        return reviewRepository.findByAudiocastId(audiocastId);
    }

    // Find reviews by user ID
    public List<Review> findByUserId(int userId) {
        return reviewRepository.findByUserId(userId);
    }
}
