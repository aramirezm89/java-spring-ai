package com.aramirezm.medassistant;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Objects;

//@Component
@RequiredArgsConstructor
@Slf4j
public class TestLlmCall implements CommandLineRunner {

    private final ChatModel chatModel;

    @Override
    public void run(String... args) throws Exception {
        var promt = new Prompt("explica en 2 lineas que es zelda ocarina of time");
        ChatResponse chatResponse = chatModel.call(promt);
        String content = chatResponse.getResult().getOutput().getText();

        log.info("---------Contenido completo");
        log.info("Contenido: {}", content);

        log.info("----------METADATA------");
        log.info("Modelo: {}", chatResponse.getMetadata().getModel());

        log.info("Tokens de entrada: {}",chatResponse.getMetadata().getUsage().getPromptTokens());
        log.info("Tokens de salida {}",chatResponse.getMetadata().getUsage().getCompletionTokens());
        log.info("Tokens totales {}",chatResponse.getMetadata().getUsage().getTotalTokens());
        log.info("Razon de la finalizacion {}",chatResponse.getResult().getMetadata().getFinishReason());

    }
}
