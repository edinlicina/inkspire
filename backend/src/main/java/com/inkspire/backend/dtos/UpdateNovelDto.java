package com.inkspire.backend.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateNovelDto {
    private String title;
    private String description;
}
