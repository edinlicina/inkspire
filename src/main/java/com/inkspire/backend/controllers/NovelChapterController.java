package com.inkspire.backend.controllers;

import com.inkspire.backend.dtos.CreateNovelChapterDto;
import com.inkspire.backend.dtos.NovelChapterDto;
import com.inkspire.backend.dtos.UpdateNovelChapterDto;
import com.inkspire.backend.exceptions.EntityNotFoundException;
import com.inkspire.backend.services.NovelChapterService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    public List<NovelChapterDto> getNovelChapters() {
        return novelChapterService.getChapters();
    }

    @DeleteMapping("/{id}")
    public void deleteNovelChapter(@PathVariable int id) {
        novelChapterService.deleteNovelChapter(id);
    }

    @PutMapping("/{id}")
    public void updateNovelChapter(@PathVariable int id, @RequestBody UpdateNovelChapterDto updateNovelChapterDto) {
        try {
            novelChapterService.updateNovelChapter(id, updateNovelChapterDto);

        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Novel Chapter not found"
            );
        }

    }
}
