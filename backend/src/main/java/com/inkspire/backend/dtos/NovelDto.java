package com.inkspire.backend.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class NovelDto {
    private Integer id;
    private String title;
    private String description;
    private List<NovelChapterDto> chapters;

}
