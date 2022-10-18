package com.buimanhthanh.englishappapi.dao;

import com.buimanhthanh.englishappapi.dto.TopicDTO;
import com.buimanhthanh.englishappapi.entity.Topic;

import java.util.List;
import java.util.Optional;

public interface TopicDAO {
    Optional<List<TopicDTO>> findAll();
    Optional<TopicDTO> findOne(Integer id);
    boolean saveOrUpdate(Topic topic);
    void saveOrUpdate(List<Topic> topics);
    void delete(Integer id);
    void delete(List<Integer> ids);
}
