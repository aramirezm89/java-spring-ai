package com.aramirezm.medassistant.service.impl;

import com.aramirezm.medassistant.service.IAssistantService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;


@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AssistantServiceImpl implements IAssistantService {
    private final ChatClient chatClient;
    @Override
    public String chat(String prompt) {

        return this.chatClient.prompt(prompt).call().content();
    }

    @Override
    public Flux<String> chatStream(String prompt) {
        return chatClient.prompt(prompt)
                .stream()
                .content();
    }
}
