package com.buimanhthanh.englishappapi.service.impl;

import com.buimanhthanh.englishappapi.dao.RankDAO;
import com.buimanhthanh.englishappapi.dto.RankDTO;
import com.buimanhthanh.englishappapi.entity.Rank;
import com.buimanhthanh.englishappapi.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RankServiceImpl implements RankService {

    @Autowired
    private RankDAO rankDAO;

    @Override
    public Optional<List<RankDTO>> findAll() {
        return rankDAO.findAll();
    }

    @Override
    public Optional<RankDTO> findOne(Integer id) {
        return rankDAO.findOne(id);
    }

    @Override
    public boolean saveOrUpdate(RankDTO rankDTO) {
        Rank rank = new Rank(rankDTO.getId(), rankDTO.getName(), rankDTO.getDescription(), rankDTO.getRepersent(), rankDTO.getType(), null);
        return rankDAO.saveOrUpdate(rank);
    }

    @Override
    public void saveOrUpdate(List<RankDTO> rankDTOs) {
        rankDTOs.forEach(this::saveOrUpdate);
    }

    @Override
    public void delete(Integer id) {
        rankDAO.delete(id);
    }

    @Override
    public void delete(List<Integer> ids) {
        rankDAO.delete(ids);
    }
}
