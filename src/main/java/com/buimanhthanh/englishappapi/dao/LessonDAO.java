package com.buimanhthanh.englishappapi.dao;

import com.buimanhthanh.englishappapi.dto.LessonDTO;
import com.buimanhthanh.englishappapi.entity.Lesson;

import java.util.List;
import java.util.Optional;

public interface LessonDAO {
    Optional<List<LessonDTO>> findAll();
    Optional<LessonDTO> findOne(Integer id);
    boolean saveOrUpdate(Lesson lesson);
    void saveOrUpdate(List<Lesson> lessons);
    void delete(Integer id);
    void delete(List<Integer> ids);
}
