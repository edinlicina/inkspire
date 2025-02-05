package com.inkspire.backend.controllers;

import com.inkspire.backend.dtos.CreateNovelDto;
import com.inkspire.backend.dtos.NovelDto;
import com.inkspire.backend.services.NovelChapterService;
import com.inkspire.backend.services.NovelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/novel")
public class NovelController {
    private final NovelService novelService;

    public NovelController(NovelService novelService) {
        this.novelService = novelService;
    }
    @PostMapping
    public NovelDto createNovel(@RequestBody CreateNovelDto createNovelDto){
        return novelService.createNovel(createNovelDto);
    }
    @GetMapping
    public List<NovelDto> getNovels(){
        return novelService.getNovels();
    }
}
