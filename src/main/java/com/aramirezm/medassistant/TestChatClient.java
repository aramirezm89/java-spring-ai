package com.aramirezm.medassistant;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
@RequiredArgsConstructor
@Slf4j
public class TestChatClient implements CommandLineRunner {

    private final ChatClient chatClient;


    @Override
    public void run(String... args) throws Exception {

        String response = chatClient.prompt("breve descripcion zelda majoras mask")
                .call()
                .content();

        log.info(response);

    }


}
