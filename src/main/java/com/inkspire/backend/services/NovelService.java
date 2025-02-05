package com.inkspire.backend.services;

import com.inkspire.backend.dtos.CreateNovelDto;
import com.inkspire.backend.dtos.NovelDto;
import com.inkspire.backend.entities.NovelEntity;
import com.inkspire.backend.mappers.NovelMappers;
import com.inkspire.backend.repositories.NovelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NovelService {
    private final NovelRepository novelRepository;

    public NovelService(NovelRepository novelRepository) {
        this.novelRepository = novelRepository;
    }

    public NovelDto createNovel(CreateNovelDto createNovelDto){
        NovelEntity novelEntity = new NovelEntity();
        novelEntity.setDescription(createNovelDto.getDescription());
        novelEntity.setTitle(createNovelDto.getTitle());
        NovelEntity createdNovel = novelRepository.save(novelEntity);
        return NovelMappers.toDto(createdNovel);
    }
    public List<NovelDto> getNovels(){
        return novelRepository.findAll().stream().map(NovelMappers::toDto).toList();
    }
}
