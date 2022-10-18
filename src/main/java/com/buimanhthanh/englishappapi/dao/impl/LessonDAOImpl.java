package com.buimanhthanh.englishappapi.dao.impl;

import com.buimanhthanh.englishappapi.dao.LessonDAO;
import com.buimanhthanh.englishappapi.dto.LessonDTO;
import com.buimanhthanh.englishappapi.entity.Lesson;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class LessonDAOImpl implements LessonDAO {

    @Autowired private EntityManager entityManager;

    @Override
    public Optional<List<LessonDTO>> findAll() {
        return Optional.ofNullable(
                entityManager.unwrap(Session.class).createQuery("select new com.buimanhthanh.englishappapi.dto.LessonDTO(l.id,l.name,l.target,l.description) from Lesson l",LessonDTO.class)
                        .getResultList()
        );
    }

    @Override
    public Optional<LessonDTO> findOne(Integer id) {
        return entityManager.unwrap(Session.class).createQuery("select new com.buimanhthanh.englishappapi.dto.LessonDTO(l.id,l.name,l.target,l.description) from Lesson l where l.id =: i",LessonDTO.class)
                        .setParameter("i",id).stream().findFirst();
    }

    @Override
    public boolean saveOrUpdate(Lesson lesson) {
        try {
            entityManager.unwrap(Session.class).saveOrUpdate(lesson);
            return true;
        }catch (HibernateException e){
            System.out.println("CAN NOT SAVE OR UPDATE LESSON");
        }
        return false;
    }

    @Override
    public void saveOrUpdate(List<Lesson> lessons) {
        lessons.forEach(this::saveOrUpdate);
    }

    @Override
    public void delete(Integer id) {
        entityManager.unwrap(Session.class).createQuery("delete from Lesson l where l.id =:i").setParameter("i",id).executeUpdate();
    }

    @Override
    public void delete(List<Integer> ids) {
        ids.forEach(this::delete);
    }
}
