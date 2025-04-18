package com.Projet.Jasser.Services;

import com.Projet.Jasser.Entity.User;
import com.Projet.Jasser.Repository.UserRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class SearchService {
    @Autowired
    private UserRepository userRepository;



    public Map<String, Object> searchAll(String query) {
        List<User> users = userRepository.searchUsersAcrossFields(query);

        Map<String, Object> result = new HashMap<>();
        result.put("users", users);

        return result;
    }
}
