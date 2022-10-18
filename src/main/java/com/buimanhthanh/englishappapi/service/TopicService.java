package com.buimanhthanh.englishappapi.service;

import com.buimanhthanh.englishappapi.dto.TopicDTO;

import java.util.List;
import java.util.Optional;

public interface TopicService {
    Optional<List<TopicDTO>> findAll();
    Optional<TopicDTO> findOne(Integer id);
    boolean saveOrUpdate(TopicDTO topicDTO);
    void saveOrUpdate(List<TopicDTO> topicDTOs);
    void delete(Integer id);
    void delete(List<Integer> ids);
}
