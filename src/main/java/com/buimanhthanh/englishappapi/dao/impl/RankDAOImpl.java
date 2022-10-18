package com.buimanhthanh.englishappapi.dao.impl;

import com.buimanhthanh.englishappapi.dao.RankDAO;
import com.buimanhthanh.englishappapi.dto.RankDTO;
import com.buimanhthanh.englishappapi.entity.Rank;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class RankDAOImpl implements RankDAO {
    @Autowired private EntityManager entityManager;

    @Override
    public Optional<List<RankDTO>> findAll() {
        return Optional.ofNullable(
                entityManager.unwrap(Session.class).createQuery("select new com.buimanhthanh.englishappapi.dto.RankDTO(r.id,r.name,r.description,r.repersent,r.type) from Rank r",RankDTO.class)
                        .getResultList()
        );
    }

    @Override
    public Optional<RankDTO> findOne(Integer id) {
        return entityManager.unwrap(Session.class).createQuery("select new com.buimanhthanh.englishappapi.dto.RankDTO(r.id,r.name,r.description,r.repersent,r.type) from Rank r where r.id =: i",RankDTO.class)
                        .setParameter("i",id).stream().findFirst();
    }

    @Override
    public boolean saveOrUpdate(Rank rank) {
        try {
            entityManager.unwrap(Session.class).saveOrUpdate(rank);
            return true;
        }catch (HibernateException e){
            System.out.println("Can not save or update rank");
        }
        return false;
    }

    @Override
    public void saveOrUpdate(List<Rank> ranks) {
        ranks.forEach(this::saveOrUpdate);
    }

    @Override
    public void delete(Integer id) {
        entityManager.unwrap(Session.class).createQuery("delete Rank r where r.id =:i").setParameter("i",id).executeUpdate();
    }

    @Override
    public void delete(List<Integer> ids) {
        ids.forEach(this::delete);
    }
}
