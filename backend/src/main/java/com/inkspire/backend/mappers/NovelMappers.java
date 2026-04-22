package com.inkspire.backend.mappers;

import com.inkspire.backend.dtos.NovelChapterDto;
import com.inkspire.backend.dtos.NovelDto;
import com.inkspire.backend.entities.NovelEntity;

import java.util.ArrayList;
import java.util.List;

public class NovelMappers {
    public static NovelDto toDto(NovelEntity novelEntity) {
        List<NovelChapterDto> novelChapters = new ArrayList<>();
        if (novelEntity.getNovelChapters() != null) {
            novelChapters = novelEntity
                    .getNovelChapters()
                    .stream()
                    .map(novelChapterEntity -> {
                        return NovelChapterMappers.toDto(novelChapterEntity);
                    })
                    .toList();
        }
        NovelDto novelDto = new NovelDto();
        novelDto.setId(novelEntity.getId());
        novelDto.setTitle(novelEntity.getTitle());
        novelDto.setDescription(novelEntity.getDescription());
        novelDto.setChapters(novelChapters);
        return novelDto;
    }
}
