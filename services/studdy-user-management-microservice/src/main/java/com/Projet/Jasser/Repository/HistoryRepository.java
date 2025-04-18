package com.Projet.Jasser.Repository;

import com.Projet.Jasser.Entity.Historic;
import com.Projet.Jasser.Entity.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HistoryRepository extends JpaRepository<Historic, Long> {
    @Query("SELECT h FROM Historic h WHERE h.user.userId = :userId")
    List<Historic> findHistoricByUserUser(@Param("userId") Long userId);

}
