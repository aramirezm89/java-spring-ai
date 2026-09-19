package com.aramirezm.medassistant.chat;


import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping ("/api/v1/chat")
@RequiredArgsConstructor
public class ChatController {

    private final ChatClient chatClient;

    @PostMapping
    public ResponseEntity<?> chat(@RequestBody String prompt) {
        var response = chatClient.prompt(prompt)
                .call()
                .content();

        return ResponseEntity.ok(Map.of("respuesta", response));
    }
}
