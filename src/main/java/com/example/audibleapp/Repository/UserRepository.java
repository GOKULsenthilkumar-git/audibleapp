package com.example.audibleapp.Repository;

import com.example.audibleapp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // Custom query to find a user by email
    User findByEmail(String email);
}