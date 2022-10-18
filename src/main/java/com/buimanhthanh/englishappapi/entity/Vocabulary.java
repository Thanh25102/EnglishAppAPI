package com.buimanhthanh.englishappapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="vocabulary")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vocabulary {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "vocabulary")
    private String vocabulary;
    @Basic
    @Column(name = "phonetic")
    private String phonetic;
    @Basic
    @Column(name = "mean")
    private String mean;
    @Basic
    @Column(name = "audio")
    private String audio;
    @Basic
    @Column(name = "image")
    private String image;
    @Basic
    @Column(name = "example_sentences")
    private String exampleSentences;
    @Basic
    @Column(name = "meaning_exp")
    private String meaningExp;
    @ManyToMany(mappedBy = "vocabularies")
    private Set<Account> accounts;
    @ManyToOne
    @JoinColumn(name = "topic_id", referencedColumnName = "id", nullable = false)
    private Topic topicByTopicIdVocabulary;

}
