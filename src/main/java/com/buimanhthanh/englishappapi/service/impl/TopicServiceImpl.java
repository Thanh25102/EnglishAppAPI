package com.buimanhthanh.englishappapi.service.impl;

import com.buimanhthanh.englishappapi.dao.TopicDAO;
import com.buimanhthanh.englishappapi.dto.TopicDTO;
import com.buimanhthanh.englishappapi.entity.Lesson;
import com.buimanhthanh.englishappapi.entity.Topic;
import com.buimanhthanh.englishappapi.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TopicServiceImpl implements TopicService {
    @Autowired
    private TopicDAO topicDAO;

    @Override
    public Optional<List<TopicDTO>> findAll() {
        return topicDAO.findAll();
    }

    @Override
    public Optional<TopicDTO> findOne(Integer id) {
        return topicDAO.findOne(id);
    }

    @Override
    public boolean saveOrUpdate(TopicDTO topicDTO) {
        Lesson lesson = new Lesson();
        lesson.setId(topicDTO.getLessonId());
        Topic topic = new Topic(topicDTO.getId(), topicDTO.getRepresent(), topicDTO.getDescription(), topicDTO.getDescriptiveMeaning(), null, lesson, null);
        return topicDAO.saveOrUpdate(topic);
    }

    @Override
    public void saveOrUpdate(List<TopicDTO> topicDTOs) {
        topicDTOs.forEach(this::saveOrUpdate);
    }

    @Override
    public void delete(Integer id) {
        topicDAO.delete(id);
    }

    @Override
    public void delete(List<Integer> ids) {
        topicDAO.delete(ids);
    }
}
