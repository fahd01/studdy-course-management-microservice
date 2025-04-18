package com.Projet.Jasser.Repository;

import com.Projet.Jasser.Entity.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {
    @Query("SELECT r FROM Reclamation r WHERE r.user.userId = :userId")
    List<Reclamation> findByUserUserId(@Param("userId") Long userId);

}
