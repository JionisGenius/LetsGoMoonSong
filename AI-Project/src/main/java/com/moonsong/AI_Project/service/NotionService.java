package com.moonsong.AI_Project.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Service
public class NotionService {

    @Value("${NOTION_API_KEY}")
    private String notionApiKey;

    @Value("${NOTION_DB_ID}")
    private String databaseId;

    private final WebClient webClient;

    public NotionService(@Value("${NOTION_API_KEY}") String notionApiKey) {
        this.webClient = WebClient.builder()
                .baseUrl("https://api.notion.com/v1/")
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + notionApiKey)
                .defaultHeader("Notion-Version", "2022-06-28")
                .build();
    }

    public void save(String title, String content) {
        Map<String, Object> body = Map.of(
            "parent", Map.of("database_id", databaseId),
            "properties", Map.of(
                "제목", Map.of("title", List.of(Map.of("text", Map.of("content", title)))),
                "내용", Map.of("rich_text", List.of(Map.of("text", Map.of("content", content))))
            )
        );

        webClient.post()
            .uri("pages")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(body)
            .retrieve()
            .bodyToMono(String.class)
            .subscribe(response -> {
                System.out.println("✅ 저장됨: " + title);
            }, error -> {
                System.err.println("❌ 저장 실패: " + error.getMessage());
            });
    }
}
