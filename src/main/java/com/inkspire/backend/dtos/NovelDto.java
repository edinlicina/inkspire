package com.inkspire.backend.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NovelDto {
    private Integer id;
    private String title;
    private String description;

}
