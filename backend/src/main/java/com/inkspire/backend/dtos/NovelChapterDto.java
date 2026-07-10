package com.inkspire.backend.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NovelChapterDto {

    private Integer id;
    private String title;
    private Integer chapterNumber;
    private String content;
}
