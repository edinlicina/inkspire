package com.inkspire.backend.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateNovelDto {
    private String title;
    private String description;

}
