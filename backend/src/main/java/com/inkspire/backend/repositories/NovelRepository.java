package com.inkspire.backend.repositories;

import com.inkspire.backend.entities.NovelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NovelRepository extends JpaRepository<NovelEntity, Integer> {
}
