package com.inkspire.backend.mappers;

import com.inkspire.backend.dtos.NovelChapterDto;
import com.inkspire.backend.entities.NovelChapterEntity;

public class NovelChapterMappers {
    public static NovelChapterDto toDto(NovelChapterEntity novelChapterEntity){
        NovelChapterDto novelChapterDto = new NovelChapterDto();
        novelChapterDto.setChapterCount(novelChapterEntity.getChapterCount());
        novelChapterDto.setId(novelChapterEntity.getId());
        novelChapterDto.setContent(novelChapterEntity.getContent());
        novelChapterDto.setTitle(novelChapterEntity.getTitle());
        return novelChapterDto;
    }
}
