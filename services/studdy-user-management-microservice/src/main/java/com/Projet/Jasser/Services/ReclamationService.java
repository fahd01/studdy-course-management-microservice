package com.Projet.Jasser.Services;

import com.Projet.Jasser.Entity.Reclamation;
import com.Projet.Jasser.Repository.ReclamationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service

public class ReclamationService {
    @Autowired
    private ReclamationRepository reclamationRepository;

    public Reclamation createReclamation(Reclamation reclamation) {
        return reclamationRepository.save(reclamation);
    }

    // Get all reclamations
    public List<Reclamation> getAllReclamations() {
        return reclamationRepository.findAll();
    }

    // Get a reclamation by ID
    public Optional<Reclamation> getReclamationById(Long id) {
        return reclamationRepository.findById(id);
    }

    // Update a reclamation
    public Reclamation updateReclamation(Reclamation reclamation) {
        return reclamationRepository.save(reclamation);
    }



    // Delete a reclamation
    public void deleteReclamation(Long id) {
        reclamationRepository.deleteById(id);
    }

    public List<Reclamation> getReclamationsByUser(Long userId) {
        return reclamationRepository.findByUserUserId(userId);
    }

}
