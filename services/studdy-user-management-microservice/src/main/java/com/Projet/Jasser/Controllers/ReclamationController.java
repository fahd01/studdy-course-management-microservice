package com.Projet.Jasser.Controllers;

import com.Projet.Jasser.Entity.Historic;
import com.Projet.Jasser.Entity.Reclamation;
import com.Projet.Jasser.Entity.User;
import com.Projet.Jasser.Interfaces.UserService;
import com.Projet.Jasser.Repository.HistoryRepository;
import com.Projet.Jasser.Services.HistoryService;
import com.Projet.Jasser.Services.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reclamations")
@CrossOrigin(origins = "*")

public class ReclamationController {
    @Autowired
    private ReclamationService reclamationService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private UserService userService;
    @PostMapping("/createReclamation/{userId}")
    public ResponseEntity<?> createReclamation(@PathVariable Long userId, @RequestBody Reclamation reclamation) {
        // Fetch the user from the database
        User user = userService.getUserById(userId);
        if (user == null) {
            return ResponseEntity.badRequest().body("User not found");
        }

        // Set the user in the reclamation
        reclamation.setUser(user);

        // Set timestamps
        reclamation.setCreatedAt(LocalDateTime.now());
        reclamation.setUpdatedAt(LocalDateTime.now());

        // Save the reclamation
        Reclamation savedReclamation = reclamationService.createReclamation(reclamation);

        // Création de l'historique
        Historic historic = new Historic();
        historic.setMessage("Réclamation ajoutée avec succès : " + savedReclamation.getDescription());
        historic.setCreatedAt(LocalDateTime.now());
        historic.setUser(savedReclamation.getUser()); // L'utilisateur doit être défini dans la réclamation
        historyService.createHistory(historic);
        return ResponseEntity.ok(savedReclamation);
    }

    @GetMapping("/getAllReclamations")
    public List<Reclamation> getAllReclamations() {
        List<Reclamation> reclamations = reclamationService.getAllReclamations();
        System.out.println("Reclamations retrieved: " + reclamations.size());
        return reclamations;
    }

    // Get a reclamation by ID
    @GetMapping("/getReclamationById/{id}")
    public ResponseEntity<Reclamation> getReclamationById(@PathVariable Long id) {
        Optional<Reclamation> reclamation = reclamationService.getReclamationById(id);
        return reclamation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a reclamation
    @PutMapping("/updateReclamation/{id}")
    public ResponseEntity<Reclamation> updateReclamation(@PathVariable Long id, @RequestBody Reclamation updatedReclamation) {
        // Fetch the existing reclamation from the database
        Optional<Reclamation> existingReclamationOpt = reclamationService.getReclamationById(id);
        if (existingReclamationOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Reclamation existingReclamation = existingReclamationOpt.get();

        // Update the fields
        existingReclamation.setDescription(updatedReclamation.getDescription());
        existingReclamation.setStatus(updatedReclamation.getStatus());
        existingReclamation.setUpdatedAt(LocalDateTime.now());

        // Save the updated reclamation
        Reclamation savedReclamation = reclamationService.updateReclamation(existingReclamation);
        return ResponseEntity.ok(savedReclamation);
    }

    // Delete a reclamation
    @DeleteMapping("/deleteReclamation/{id}")
    public ResponseEntity<Void> deleteReclamation(@PathVariable Long id) {
        reclamationService.deleteReclamation(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getReclamationsByUser/{userId}")
    public List<Reclamation> getReclamationsByUser(@PathVariable Long userId) {
        return reclamationService.getReclamationsByUser(userId);
    }

}
