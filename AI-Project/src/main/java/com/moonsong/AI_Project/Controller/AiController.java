package com.moonsong.AI_Project.Controller;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class AiController {

    private final OpenAiChatModel openAiChatModel;

    public AiController(OpenAiChatModel openAiChatModel){
        this.openAiChatModel = openAiChatModel;
    }

    @Value("${OPENAI_API_KEY}")
    private String apiKey;

    @GetMapping("/chatGPT")
    public ResponseEntity<String> chat (@RequestParam("message") String message){
        String result = openAiChatModel.call(message);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
