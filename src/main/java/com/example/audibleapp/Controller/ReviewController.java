package com.example.audibleapp.Controller;

import com.example.audibleapp.Model.Review;
import com.example.audibleapp.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // Get all reviews
    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    // Get a review by ID
    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable int id) {
        return reviewService.getReviewById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new review
    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return reviewService.createReview(review);
    }

    // Update an existing review
    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable int id, @RequestBody Review reviewDetails) {
        return ResponseEntity.ok(reviewService.updateReview(id, reviewDetails));
    }

    // Delete a review
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable int id) {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }

    // Find reviews by audiocast ID
    @GetMapping("/audiocast/{audiocastId}")
    public List<Review> getReviewsByAudiocastId(@PathVariable int audiocastId) {
        return reviewService.findByAudiocastId(audiocastId);
    }

    // Find reviews by user ID
    @GetMapping("/user/{userId}")
    public List<Review> getReviewsByUserId(@PathVariable int userId) {
        return reviewService.findByUserId(userId);
    }
}