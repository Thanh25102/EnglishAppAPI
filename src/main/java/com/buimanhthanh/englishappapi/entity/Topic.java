package com.buimanhthanh.englishappapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "topic")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topic {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "represent")
    private String represent;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "descriptive_meaning")
    private String descriptiveMeaning;
    @ManyToMany(mappedBy = "topics")
    private Set<Account> accounts;
    @ManyToOne
    @JoinColumn(name = "lesson_id", referencedColumnName = "id", nullable = false)
    private Lesson lessonByLessonId;
    @OneToMany(mappedBy = "topicByTopicIdVocabulary")
    private Collection<Vocabulary> vocabulariesById;

}
