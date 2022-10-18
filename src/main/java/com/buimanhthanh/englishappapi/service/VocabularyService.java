package com.buimanhthanh.englishappapi.service;

import com.buimanhthanh.englishappapi.dto.VocabularyDTO;
import com.buimanhthanh.englishappapi.entity.Vocabulary;

import java.util.List;
import java.util.Optional;

public interface VocabularyService {
    Optional<List<VocabularyDTO>> findAll();

    Optional<VocabularyDTO> findOne(Integer id);

    boolean saveOrUpdate(VocabularyDTO vocabularyDTO);

    void saveOrUpdate(List<Vocabulary> vocabularies);

    void delete(Integer id);

    void delete(List<Integer> ids);
}
