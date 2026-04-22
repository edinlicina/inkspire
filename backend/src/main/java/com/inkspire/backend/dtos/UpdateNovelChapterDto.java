package com.inkspire.backend.dtos;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateNovelChapterDto {
    private String title;
    private String content;
    private String chapterCount;

}
