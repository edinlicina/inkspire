package com.inkspire.backend.services;

import com.inkspire.backend.dtos.CreateNovelChapterDto;
import com.inkspire.backend.dtos.CreateNovelDto;
import com.inkspire.backend.dtos.NovelDto;
import com.inkspire.backend.dtos.UpdateNovelDto;
import com.inkspire.backend.entities.NovelChapterEntity;
import com.inkspire.backend.entities.NovelEntity;
import com.inkspire.backend.exceptions.EntityNotFoundException;
import com.inkspire.backend.mappers.NovelMappers;
import com.inkspire.backend.repositories.NovelChapterRepository;
import com.inkspire.backend.repositories.NovelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NovelService {
    private final NovelRepository novelRepository;
    private final NovelChapterRepository novelChapterRepository;
    private final NovelChapterService novelChapterService;


    public NovelService(NovelRepository novelRepository, NovelChapterRepository novelChapterRepository, NovelChapterService novelChapterService) {
        this.novelRepository = novelRepository;
        this.novelChapterRepository = novelChapterRepository;
        this.novelChapterService = novelChapterService;
    }

    public NovelDto createNovel(CreateNovelDto createNovelDto) {
        NovelEntity novelEntity = new NovelEntity();
        novelEntity.setDescription(createNovelDto.getDescription());
        novelEntity.setTitle(createNovelDto.getTitle());
        NovelEntity createdNovel = novelRepository.save(novelEntity);
        return NovelMappers.toDto(createdNovel);
    }

    public List<NovelDto> getNovels() {
        return novelRepository.findAll().stream().map(NovelMappers::toDto).toList();
    }

    public void deleteNovel(int id) {
        novelRepository.deleteById(id);
    }

    public NovelDto updateNovel(int id, UpdateNovelDto updateNovelDto) {
        Optional<NovelEntity> optionalNovelEntity = novelRepository.findById(id);
        if (optionalNovelEntity.isEmpty()) {
            throw new EntityNotFoundException();
        }
        NovelEntity novelEntity = optionalNovelEntity.get();
        novelEntity.setTitle(updateNovelDto.getTitle());
        novelEntity.setDescription(updateNovelDto.getDescription());
        NovelEntity updatedNovel = novelRepository.save(novelEntity);
        return NovelMappers.toDto(updatedNovel);
    }

    public NovelDto createNovelChapter(int novelId, CreateNovelChapterDto createNovelChapterDto) {

        Optional<NovelEntity> optionalNovelEntity = novelRepository.findById(novelId);
        if (optionalNovelEntity.isEmpty()) {
            throw new EntityNotFoundException();
        }
        NovelChapterEntity novelChapterEntity = novelChapterService.createNovelChapterEntity(createNovelChapterDto);
        NovelEntity novelEntity = optionalNovelEntity.get();
        novelEntity.addNovelChapter(novelChapterEntity);
        NovelEntity novelChapterDto = novelRepository.save(novelEntity);
        return NovelMappers.toDto(novelChapterDto);
    }
}
