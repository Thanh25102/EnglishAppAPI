package com.buimanhthanh.englishappapi.dao.impl;

import com.buimanhthanh.englishappapi.dao.TopicDAO;
import com.buimanhthanh.englishappapi.dto.TopicDTO;
import com.buimanhthanh.englishappapi.entity.Topic;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class TopicDAOImpl implements TopicDAO {
    @Autowired private EntityManager entityManager;
    @Override
    public Optional<List<TopicDTO>> findAll() {
        return Optional.ofNullable(
                entityManager.unwrap(Session.class).createQuery("select new com.buimanhthanh.englishappapi.dto.TopicDTO(t.id,t.represent,t.description,t.descriptiveMeaning,t.lessonByLessonId.id) from Topic t",TopicDTO.class).getResultList()
        );
    }

    @Override
    public Optional<TopicDTO> findOne(Integer id) {
        return entityManager.unwrap(Session.class).createQuery("select new com.buimanhthanh.englishappapi.dto.TopicDTO(t.id,t.represent,t.description,t.descriptiveMeaning,t.lessonByLessonId.id) from Topic t where t.id =:i", TopicDTO.class)
                .setParameter("i",id).stream().findFirst();
    }

    @Override
    public boolean saveOrUpdate(Topic topic) {
        try {
            entityManager.unwrap(Session.class).saveOrUpdate(topic);
            return true;
        }catch (HibernateException e){
            System.out.println("Can not save or update topic");
        }
        return false;
    }

    @Override
    public void saveOrUpdate(List<Topic> topics) {
        topics.forEach(this::saveOrUpdate);
    }

    @Override
    public void delete(Integer id) {
        entityManager.unwrap(Session.class).createQuery("delete Topic t where t.id =: i").setParameter("i",id).executeUpdate();
    }

    @Override
    public void delete(List<Integer> ids) {
        ids.forEach(this::delete);
    }
}
