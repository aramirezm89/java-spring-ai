package com.aramirezm.medassistant.controller;

import com.aramirezm.medassistant.DTO.ChatRequest;
import com.aramirezm.medassistant.service.IAssistantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;


@RestController
@RequestMapping ("/api/v1/chat")
@RequiredArgsConstructor
public class ChatController {

 private final IAssistantService assistantService;

    @PostMapping
    public ResponseEntity<?> chat(@RequestBody ChatRequest request) {

        return ResponseEntity.ok(this.assistantService.chat(request.prompt()));
    }

    @PostMapping(value = "/stream", produces = "text/event-stream; charset=UTF-8")
    public ResponseEntity<Flux<String>> chatStreaming(@RequestBody ChatRequest request) {
        return ResponseEntity.ok(this.assistantService.chatStream(request.prompt()));
    }
}
