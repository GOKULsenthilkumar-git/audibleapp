package com.example.audibleapp.Repository;

import com.example.audibleapp.Model.Creator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreatorRepository extends JpaRepository<Creator, Integer> {
    // Custom query to find a creator by name
    Creator findByName(String name);
}