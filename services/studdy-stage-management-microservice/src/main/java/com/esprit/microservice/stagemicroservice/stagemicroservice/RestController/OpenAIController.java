package com.esprit.microservice.stagemicroservice.stagemicroservice.RestController;
import com.esprit.microservice.stagemicroservice.stagemicroservice.Service.OpenAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/gpt")
@ConditionalOnProperty(name = "openai.api.key")
public class OpenAIController {

    @Autowired
    private OpenAIService openAIService;

    @PostMapping("/ask")
    public String askGPT(@RequestBody Map<String, String> request) throws IOException {
        String userMessage = request.get("message");
        return openAIService.generateResponse(userMessage);
    }
}
