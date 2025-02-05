package com.inkspire.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}
