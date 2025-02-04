package com.inkspire.backend.services;


import com.inkspire.backend.dtos.CreateNovelChapterDto;
import com.inkspire.backend.dtos.UpdateNovelChapterDto;
import com.inkspire.backend.entities.NovelChapterEntity;
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

    public void createChapter(CreateNovelChapterDto createNovelChapterDto) {
        NovelChapterEntity novelChapterEntity = new NovelChapterEntity();
        novelChapterEntity.setChapterCount(createNovelChapterDto.getChapterCount());
        novelChapterEntity.setContent(createNovelChapterDto.getContent());
        novelChapterEntity.setTitle(createNovelChapterDto.getTitle());
        novelChapterRepository.save(novelChapterEntity);
    }
    public List<NovelChapterEntity> getChapters(){
        List<NovelChapterEntity> novelChapters = novelChapterRepository.findAll();
        return novelChapters;
    }
    public void deleteNovelChapter(int id){
      novelChapterRepository.deleteById(id);
    }
    public void updateNovelChapter(int id, UpdateNovelChapterDto updateNovelChapterDto){
    Optional<NovelChapterEntity> optionalNovelChapterEntity = novelChapterRepository.findById(id);
    NovelChapterEntity novelChapterEntity = optionalNovelChapterEntity.get();
    novelChapterEntity.setTitle(updateNovelChapterDto.getTitle());
    novelChapterEntity.setChapterCount(updateNovelChapterDto.getChapterCount());
    novelChapterEntity.setContent(updateNovelChapterDto.getContent());
    novelChapterRepository.save(novelChapterEntity);
    }
}
