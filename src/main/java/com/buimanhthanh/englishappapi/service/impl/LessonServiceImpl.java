package com.buimanhthanh.englishappapi.service.impl;

import com.buimanhthanh.englishappapi.dao.LessonDAO;
import com.buimanhthanh.englishappapi.dto.LessonDTO;
import com.buimanhthanh.englishappapi.entity.Lesson;
import com.buimanhthanh.englishappapi.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonDAO lessonDAO;

    @Override
    @Transactional
    public Optional<List<LessonDTO>> findAll() {
        return lessonDAO.findAll();
    }

    @Override
    @Transactional
    public Optional<LessonDTO> findOne(Integer id) {
        return lessonDAO.findOne(id);
    }

    @Override
    @Transactional
    public boolean saveOrUpdate(Lesson lesson) {
        return lessonDAO.saveOrUpdate(lesson);
    }

    @Override
    @Transactional
    public void saveOrUpdate(List<Lesson> lessons) {
        lessonDAO.saveOrUpdate(lessons);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        lessonDAO.delete(id);
    }

    @Override
    @Transactional
    public void delete(List<Integer> ids) {
        lessonDAO.delete(ids);
    }
}
