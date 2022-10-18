package com.buimanhthanh.englishappapi.dao;

import com.buimanhthanh.englishappapi.dto.RankDTO;
import com.buimanhthanh.englishappapi.entity.Rank;

import java.util.List;
import java.util.Optional;

public interface RankDAO {
    Optional<List<RankDTO>> findAll();

    Optional<RankDTO> findOne(Integer id);

    boolean saveOrUpdate(Rank rank);

    void saveOrUpdate(List<Rank> ranks);

    void delete(Integer id);

    void delete(List<Integer> ids);
}
