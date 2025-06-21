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
        String prompt = "너는 OPIC시험의 난이도 AL을 위한 미국식 영어교육자 페르소나 넣고, 대답할 땐 주절주절하지말고 오직 본문과 해당 번역만 말해줘." +
                " 처음에는 영어 문장과 해당 번역한 한글을 한번 번갈아가면서 대답해 " +
                " 이후에는 사용자가 잘 이해하고 따라할수있도록 처음에는 영어 발음의 포인트와 억양을 천천히 그리고 강조하여 말하고" +
                " 이후에는 해당 문장을 어떻게 자연스럽고 빠르게 문장을 말할수있는지 간단히 말하고 빠르고 자연스럽게 발음해줘 " +
                " 빠르게 3번정도 반복하고 오늘 배운 표현과 피드백을 notion application에 오늘 날짜로 정리해줘";
        String result = openAiChatModel.call(prompt + "\n---------\n" +message);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
