package com.akiacevedo.life_line_back_end.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DayRequestDto(
        @NotBlank(message = "Description is required")
        String description,
        @NotNull(message = "Score is required")
        int score
) {
}
