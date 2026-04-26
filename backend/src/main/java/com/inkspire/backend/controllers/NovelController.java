package com.inkspire.backend.controllers;

import com.inkspire.backend.dtos.CreateNovelChapterDto;
import com.inkspire.backend.dtos.CreateNovelDto;
import com.inkspire.backend.dtos.NovelDto;
import com.inkspire.backend.dtos.UpdateNovelDto;
import com.inkspire.backend.exceptions.EntityNotFoundException;
import com.inkspire.backend.services.NovelService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/novel")
public class NovelController {
    private final NovelService novelService;

    public NovelController(NovelService novelService) {
        this.novelService = novelService;
    }

    @PostMapping
    public NovelDto createNovel(@Valid @RequestBody CreateNovelDto createNovelDto) {
        return novelService.createNovel(createNovelDto);
    }

    @PostMapping("/{novelId}/novel-chapter")
    public NovelDto createNovelChapter(@PathVariable int novelId, @RequestBody CreateNovelChapterDto createNovelChapterDto) {
        try {
            return novelService.createNovelChapter(novelId, createNovelChapterDto);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Novel not found"
            );
        }
    }

    @GetMapping
    public List<NovelDto> getNovels() {
        return novelService.getNovels();
    }

    @GetMapping("/{id}")
    public NovelDto getNovelById(@PathVariable int id){return novelService.getNovelById(id);}

    @DeleteMapping("/{id}")
    public void deleteNovel(@PathVariable int id) {
        novelService.deleteNovel(id);
    }

    @PutMapping("/{id}")
    public NovelDto updateNovel(@PathVariable int id, @Valid @RequestBody UpdateNovelDto updateNovelDto) {
        try {
            return novelService.updateNovel(id, updateNovelDto);

        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Novel not found"
            );
        }
    }

}
