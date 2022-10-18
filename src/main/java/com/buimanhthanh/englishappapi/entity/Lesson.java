package com.buimanhthanh.englishappapi.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "lesson")
@Data
public class Lesson {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "target")
    private String target;
    @Basic
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "lessonByLessonId")
    private Collection<Topic> topicsById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return Objects.equals(id, lesson.id) && Objects.equals(name, lesson.name) && Objects.equals(target, lesson.target) && Objects.equals(description, lesson.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, target, description);
    }

    public Collection<Topic> getTopicsById() {
        return topicsById;
    }

    public void setTopicsById(Collection<Topic> topicsById) {
        this.topicsById = topicsById;
    }
}
