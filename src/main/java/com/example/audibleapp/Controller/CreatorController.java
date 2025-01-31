package com.example.audibleapp.Controller;

import com.example.audibleapp.Model.Creator;
import com.example.audibleapp.Service.CreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/creators")
@SuppressWarnings("unused") // Suppress the "never used" warning
public class CreatorController {
    // Controller code

    @Autowired
    private CreatorService creatorService;

    // Get all creators
    @GetMapping
    public List<Creator> getAllCreators() {
        return creatorService.getAllCreators();
    }

    // Get a creator by ID
    @GetMapping("/{id}")
    public ResponseEntity<Creator> getCreatorById(@PathVariable int id) {
        return creatorService.getCreatorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new creator
    @PostMapping
    public Creator createCreator(@RequestBody Creator creator) {
        return creatorService.createCreator(creator);
    }

    // Update an existing creator
    @PutMapping("/{id}")
    public ResponseEntity<Creator> updateCreator(@PathVariable int id, @RequestBody Creator creatorDetails) {
        return ResponseEntity.ok(creatorService.updateCreator(id, creatorDetails));
    }

    // Delete a creator
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCreator(@PathVariable int id) {
        creatorService.deleteCreator(id);
        return ResponseEntity.noContent().build();
    }

    // Find a creator by name
    @GetMapping("/name/{name}")
    public ResponseEntity<Creator> getCreatorByName(@PathVariable String name) {
        Creator creator = creatorService.findByName(name);
        if (creator != null) {
            return ResponseEntity.ok(creator);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}