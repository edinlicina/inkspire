package com.inkspire.backend.controllers;

import com.inkspire.backend.dtos.CreateNovelChapterDto;
import com.inkspire.backend.entities.NovelChapterEntity;
import com.inkspire.backend.services.NovelChapterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/novel-chapter")
public class NovelChapterController {
    private final NovelChapterService novelChapterService;

    public NovelChapterController(NovelChapterService novelChapterService) {
        this.novelChapterService = novelChapterService;
    }

    @PostMapping
    public void createNovelChapter(@RequestBody CreateNovelChapterDto createNovelChapterDto) {
        novelChapterService.createChapter(createNovelChapterDto);
    }

    @GetMapping
    public List<NovelChapterEntity> getNovelChapters() {
        return novelChapterService.getChapters();
    }

    @DeleteMapping("/{id}")
    public void deleteNovelChapter(@PathVariable int id){
        novelChapterService.deleteNovelChapter(id);
    }
}
