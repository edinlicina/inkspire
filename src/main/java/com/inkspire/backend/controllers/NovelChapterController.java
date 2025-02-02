package com.inkspire.backend.controllers;

import com.inkspire.backend.services.NovelChapterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/novel-chapter")
public class NovelChapterController {
    private final NovelChapterService novelChapterService;

    public NovelChapterController(NovelChapterService novelChapterService) {
        this.novelChapterService = novelChapterService;
    }
@PostMapping
    public void createNovelChapter(){
        novelChapterService.createChapter();
    }
}
