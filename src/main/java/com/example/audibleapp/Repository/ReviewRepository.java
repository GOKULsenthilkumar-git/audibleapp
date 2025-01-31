package com.example.audibleapp.Repository;

import com.example.audibleapp.Model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    // Custom query to find reviews by audiocast ID
    List<Review> findByAudiocastId(int audiocastId);

    // Custom query to find reviews by user ID
    List<Review> findByUserId(int userId);
}