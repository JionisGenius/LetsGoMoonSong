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

    public AiController(OpenAiChatModel openAiChatModel) {
        this.openAiChatModel = openAiChatModel;
    }

    @Value("${OPENAI_API_KEY}")
    private String apiKey;

    @GetMapping("/chatGPT")
    public ResponseEntity<String> chat(@RequestParam("message") String message) {
        String prompt = "너는 영어교육자처럼 이해하기 쉽게 번역해줘야해, 대답할 땐 주절주절하지말고 오직 본문과 해당 번역만 말해줘. 영어 문장과 해당 번역한 한글을 번갈아가면서 대답해. 해당 영어 문장은 엔터를 한번만 치고, 해당 영어 문장을 번역한 한글이 끝나면 엔터를 두 번 쳐줘.";
        String result = openAiChatModel.call(prompt + "\n---------\n" + message);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
