package com.inkspire.backend.mappers;

import com.inkspire.backend.dtos.NovelDto;
import com.inkspire.backend.entities.NovelEntity;

public class NovelMappers {
    public static NovelDto toDto(NovelEntity novelEntity) {
        NovelDto novelDto = new NovelDto();
        novelDto.setId(novelEntity.getId());
        novelDto.setTitle(novelEntity.getTitle());
        novelDto.setDescription(novelEntity.getDescription());
        novelDto.setChapters(novelEntity.getNovelChapters().stream().map(novelChapterEntity -> {
            return NovelChapterMappers.toDto(novelChapterEntity);
        }).toList());
        return novelDto;
    }
}
