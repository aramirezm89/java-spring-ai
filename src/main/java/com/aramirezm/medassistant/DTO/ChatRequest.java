package com.aramirezm.medassistant.DTO;

import jakarta.validation.constraints.NotBlank;

public record ChatRequest(
        @NotBlank(message = "El promt no puede estar vacio.")
        String prompt
) {
}
