package com.aramirezm.medassistant.service;

import reactor.core.publisher.Flux;

public interface IAssistantService {

    String chat(String prompt );

    Flux<String> chatStream(String prompt);
}
