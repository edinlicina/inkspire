package com.inkspire.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name= "novel")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NovelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;
    @Column
    private String title;
    @Column
    private String description;
    @OneToMany(mappedBy = "novel")
    private List<NovelChapterEntity> novelChapters;

    public void addNovelChapter(NovelChapterEntity novelChapterEntity) {
        novelChapters.add(novelChapterEntity);
        novelChapterEntity.setNovel(this);
    }
}
