package com.inkspire.backend.services;


import com.inkspire.backend.entities.NovelChapterEntity;
import com.inkspire.backend.repositories.NovelChapterRepository;
import org.springframework.stereotype.Service;

@Service
public class NovelChapterService {
    private final NovelChapterRepository novelChapterRepository;

    public NovelChapterService(NovelChapterRepository novelChapterRepository) {
        this.novelChapterRepository = novelChapterRepository;
    }

    public void createChapter() {
        NovelChapterEntity novelChapterEntity = new NovelChapterEntity();
        novelChapterEntity.setChapterCount("1");
        novelChapterEntity.setContent("Once upon a time");
        novelChapterEntity.setTitle("Drunken Swordmaster");
        novelChapterRepository.save(novelChapterEntity);
    }
}
