package com.inkspire.backend.controllers;

import com.inkspire.backend.dtos.CreateNovelChapterDto;
import com.inkspire.backend.dtos.NovelChapterDto;
import com.inkspire.backend.dtos.UpdateNovelChapterDto;
import com.inkspire.backend.exceptions.EntityNotFoundException;
import com.inkspire.backend.services.NovelChapterService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NovelChapterController {

    private final NovelChapterService novelChapterService;

    public NovelChapterController(
            NovelChapterService novelChapterService
    ) {
        this.novelChapterService = novelChapterService;
    }

    @PostMapping("/novel/{novelId}/chapters")
    public ResponseEntity<NovelChapterDto> createNovelChapter(
            @PathVariable int novelId,
            @Valid @RequestBody CreateNovelChapterDto dto
    ) {
        try {
            NovelChapterDto createdChapter =
                    novelChapterService.createChapter(novelId, dto);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(createdChapter);

        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Novel not found"
            );
        }
    }

    @GetMapping("/novel-chapter")
    public List<NovelChapterDto> getNovelChapters() {
        return novelChapterService.getChapters();
    }

    @GetMapping("/novel/{novelId}/chapters")
    public List<NovelChapterDto> getChaptersByNovelId(
            @PathVariable int novelId
    ) {
        return novelChapterService.getChaptersByNovelId(novelId);
    }

    @GetMapping("/novel-chapter/{id}")
    public NovelChapterDto getNovelChapterById(
            @PathVariable int id
    ) {
        try {
            return novelChapterService.getChapterById(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Novel chapter not found"
            );
        }
    }

    @DeleteMapping("/novel-chapter/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNovelChapter(@PathVariable int id) {
        try {
            novelChapterService.deleteNovelChapter(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Novel chapter not found"
            );
        }
    }

    @PutMapping("/novel-chapter/{id}")
    public NovelChapterDto updateNovelChapter(
            @PathVariable int id,
            @Valid @RequestBody UpdateNovelChapterDto dto
    ) {
        try {
            return novelChapterService.updateNovelChapter(id, dto);

        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Novel chapter not found"
            );
        }
    }
}