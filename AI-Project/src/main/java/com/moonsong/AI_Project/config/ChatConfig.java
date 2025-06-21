package com.moonsong.AI_Project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatClient;

@Configuration
public class ChatConfig {

    @Bean
    public ChatClient chatClient(OpenAiChatClient openAiChatClient) {
        return ChatClient.create(openAiChatClient);
    }
}
