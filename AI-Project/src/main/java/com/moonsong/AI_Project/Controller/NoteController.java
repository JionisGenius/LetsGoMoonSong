package com.moonsong.AI_Project.controller;

import com.moonsong.AI_Project.service.NotionService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private final ChatClient chatClient;
    private final NotionService notionService;

    public NoteController(ChatClient chatClient, NotionService notionService) {
        this.chatClient = chatClient;
        this.notionService = notionService;
    }

    @GetMapping("/summarize")
    public ResponseEntity<String> summarizeAndSave(@RequestParam("message") String message) {
        String prompt = "너는 메모 정리 AI야. 사용자의 긴 입력을 간결하고 핵심 있게 요약해서 저장할 수 있도록 정리해줘. 불필요한 말은 하지 말고 요점만 정리해.";

        String result = chatClient.prompt()
                .system(prompt)
                .user(message)
                .call()
                .content();

        notionService.save("요약 메모", result);
        return ResponseEntity.ok("✅ 저장 완료");
    }
}
