package com.inkspire.backend.services;


import com.inkspire.backend.dtos.CreateNovelChapterDto;
import com.inkspire.backend.dtos.NovelChapterDto;
import com.inkspire.backend.dtos.UpdateNovelChapterDto;
import com.inkspire.backend.entities.NovelChapterEntity;
import com.inkspire.backend.exceptions.EntityNotFoundException;
import com.inkspire.backend.mappers.NovelChapterMappers;
import com.inkspire.backend.repositories.NovelChapterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NovelChapterService {
    private final NovelChapterRepository novelChapterRepository;

    public NovelChapterService(NovelChapterRepository novelChapterRepository) {
        this.novelChapterRepository = novelChapterRepository;
    }

    public NovelChapterDto createChapter(CreateNovelChapterDto createNovelChapterDto) {
        NovelChapterEntity novelChapterEntity = new NovelChapterEntity();
        novelChapterEntity.setChapterCount(createNovelChapterDto.getChapterCount());
        novelChapterEntity.setContent(createNovelChapterDto.getContent());
        novelChapterEntity.setTitle(createNovelChapterDto.getTitle());
        NovelChapterEntity createdNovelChapter = novelChapterRepository.save(novelChapterEntity);
        return NovelChapterMappers.toDto(createdNovelChapter);
    }

    public List<NovelChapterDto> getChapters() {
        return novelChapterRepository.findAll().stream().map(NovelChapterMappers::toDto).toList();
    }

    public void deleteNovelChapter(int id) {
        novelChapterRepository.deleteById(id);
    }

    public NovelChapterDto updateNovelChapter(int id, UpdateNovelChapterDto updateNovelChapterDto) {
        Optional<NovelChapterEntity> optionalNovelChapterEntity = novelChapterRepository.findById(id);
        if (optionalNovelChapterEntity.isEmpty()) {
            throw new EntityNotFoundException();
        }
        NovelChapterEntity novelChapterEntity = optionalNovelChapterEntity.get();
        novelChapterEntity.setTitle(updateNovelChapterDto.getTitle());
        novelChapterEntity.setChapterCount(updateNovelChapterDto.getChapterCount());
        novelChapterEntity.setContent(updateNovelChapterDto.getContent());
        NovelChapterEntity updated = novelChapterRepository.save(novelChapterEntity);
        return NovelChapterMappers.toDto(updated);
    }

}
