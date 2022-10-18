package com.buimanhthanh.englishappapi.service;

import com.buimanhthanh.englishappapi.dto.RankDTO;

import java.util.List;
import java.util.Optional;

public interface RankService {
    Optional<List<RankDTO>> findAll();
    Optional<RankDTO> findOne(Integer id);
    boolean saveOrUpdate(RankDTO rankDTO);
    void saveOrUpdate(List<RankDTO> rankDTOs);
    void delete(Integer id);
    void delete(List<Integer> ids);
}
