package com.inkspire.backend.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "novel_chapter")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NovelChapterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;
    @Column
    private String title;
    @Column
    private String chapterCount;
    @Column
    private String content;
}
