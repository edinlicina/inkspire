package com.inkspire.backend.repositories;

import com.inkspire.backend.entities.NovelChapterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NovelChapterRepository
        extends JpaRepository<NovelChapterEntity, Integer> {

    boolean existsByNovelIdAndChapterNumber(
            Integer novelId,
            Integer chapterNumber
    );

    List<NovelChapterEntity> findByNovelIdOrderByChapterNumberAsc(
            Integer novelId
    );
}