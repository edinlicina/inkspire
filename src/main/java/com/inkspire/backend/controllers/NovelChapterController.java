package com.inkspire.backend.controllers;

import com.inkspire.backend.entities.NovelChapterEntity;
import com.inkspire.backend.services.NovelChapterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/novel-chapter")
public class NovelChapterController {
    private final NovelChapterService novelChapterService;

    public NovelChapterController(NovelChapterService novelChapterService) {
        this.novelChapterService = novelChapterService;
    }

    @PostMapping
    public void createNovelChapter() {
        novelChapterService.createChapter();
    }

    @GetMapping
    public List<NovelChapterEntity> getNovelChapters() {
        return novelChapterService.getChapters();
    }
}
