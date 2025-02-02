package com.inkspire.backend.repositories;

import com.inkspire.backend.entities.NovelChapterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NovelChapterRepository extends JpaRepository<NovelChapterEntity, Integer> {
}
