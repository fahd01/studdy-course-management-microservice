package com.Projet.Jasser.Services;

import com.Projet.Jasser.Entity.Historic;
import com.Projet.Jasser.Entity.Reclamation;
import com.Projet.Jasser.Entity.User;
import com.Projet.Jasser.Repository.HistoryRepository;
import com.Projet.Jasser.Repository.ReclamationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {
    @Autowired
    private HistoryRepository historyRepository;

    public Historic createHistory(Historic historic) {
        return historyRepository.save(historic);
    }

    public List<Historic> getHistoryByUserId(Long userId) {
        return historyRepository.findHistoricByUserUser(userId);
    }
}
