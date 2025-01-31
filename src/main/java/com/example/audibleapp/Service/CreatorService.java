package com.example.audibleapp.Service;

import com.example.audibleapp.Model.Creator;
import com.example.audibleapp.Repository.CreatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreatorService {

    @Autowired
    private CreatorRepository creatorRepository;

    // Get all creators
    public List<Creator> getAllCreators() {
        return creatorRepository.findAll();
    }

    // Get a creator by ID
    public Optional<Creator> getCreatorById(int id) {
        return creatorRepository.findById(id);
    }

    // Create a new creator
    public Creator createCreator(Creator creator) {
        return creatorRepository.save(creator);
    }

    // Update an existing creator
    public Creator updateCreator(int id, Creator creatorDetails) {
        Creator creator = creatorRepository.findById(id).orElseThrow(() -> new RuntimeException("Creator not found"));
        creator.setName(creatorDetails.getName());
        creator.setPassword(creatorDetails.getPassword());
        creator.setBio(creatorDetails.getBio());
        creator.setQualification(creatorDetails.getQualification());
        creator.setNationality(creatorDetails.getNationality());
        return creatorRepository.save(creator);
    }

    // Delete a creator
    public void deleteCreator(int id) {
        creatorRepository.deleteById(id);
    }

    // Find a creator by name
    public Creator findByName(String name) {
        return creatorRepository.findByName(name);
    }
}