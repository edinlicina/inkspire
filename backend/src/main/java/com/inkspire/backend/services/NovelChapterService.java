package com.inkspire.backend.services;

import com.inkspire.backend.dtos.CreateNovelChapterDto;
import com.inkspire.backend.dtos.NovelChapterDto;
import com.inkspire.backend.dtos.UpdateNovelChapterDto;
import com.inkspire.backend.entities.NovelChapterEntity;
import com.inkspire.backend.entities.NovelEntity;
import com.inkspire.backend.exceptions.EntityNotFoundException;
import com.inkspire.backend.mappers.NovelChapterMappers;
import com.inkspire.backend.repositories.NovelChapterRepository;
import com.inkspire.backend.repositories.NovelRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NovelChapterService {

    private final NovelChapterRepository novelChapterRepository;
    private final NovelRepository novelRepository;

    public NovelChapterService(
            NovelChapterRepository novelChapterRepository,
            NovelRepository novelRepository
    ) {
        this.novelChapterRepository = novelChapterRepository;
        this.novelRepository = novelRepository;
    }

    @Transactional
    public NovelChapterDto createChapter(
            int novelId,
            CreateNovelChapterDto dto
    ) {
        NovelEntity novel = novelRepository.findById(novelId)
                .orElseThrow(EntityNotFoundException::new);

        NovelChapterEntity chapter =
                createNovelChapterEntity(dto);

        novel.addNovelChapter(chapter);

        NovelChapterEntity savedChapter =
                novelChapterRepository.save(chapter);

        return NovelChapterMappers.toDto(savedChapter);
    }

    private NovelChapterEntity createNovelChapterEntity(
            CreateNovelChapterDto dto
    ) {
        NovelChapterEntity chapter = new NovelChapterEntity();

        chapter.setTitle(dto.getTitle());
        chapter.setChapterNumber(dto.getChapterNumber());
        chapter.setContent(dto.getContent());

        return chapter;
    }

    public List<NovelChapterDto> getChapters() {
        return novelChapterRepository
                .findAll()
                .stream()
                .map(NovelChapterMappers::toDto)
                .toList();
    }

    public List<NovelChapterDto> getChaptersByNovelId(int novelId) {
        return novelChapterRepository
                .findByNovelIdOrderByChapterNumberAsc(novelId)
                .stream()
                .map(NovelChapterMappers::toDto)
                .toList();
    }

    public NovelChapterDto getChapterById(int id) {
        NovelChapterEntity chapter = novelChapterRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);

        return NovelChapterMappers.toDto(chapter);
    }

    public void deleteNovelChapter(int id) {
        NovelChapterEntity chapter = novelChapterRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);

        novelChapterRepository.delete(chapter);
    }

    @Transactional
    public NovelChapterDto updateNovelChapter(
            int id,
            UpdateNovelChapterDto dto
    ) {
        NovelChapterEntity chapter = novelChapterRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);

        chapter.setTitle(dto.getTitle());
        chapter.setChapterNumber(dto.getChapterNumber());
        chapter.setContent(dto.getContent());

        NovelChapterEntity updatedChapter =
                novelChapterRepository.save(chapter);

        return NovelChapterMappers.toDto(updatedChapter);
    }
}