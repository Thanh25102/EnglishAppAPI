package com.buimanhthanh.englishappapi.dao.impl;

import com.buimanhthanh.englishappapi.dao.VocabularyDAO;
import com.buimanhthanh.englishappapi.dto.VocabularyDTO;
import com.buimanhthanh.englishappapi.entity.Vocabulary;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class VocabularyDAOImpl implements VocabularyDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public Optional<List<VocabularyDTO>> findAll() {
        return Optional.ofNullable(
                entityManager.unwrap(Session.class).createQuery("select new com.buimanhthanh.englishappapi.dto.VocabularyDTO(v.id,v.vocabulary,v.phonetic,v.mean,v.audio,v.image,v.exampleSentences,v.meaningExp,v.topicByTopicIdVocabulary.id) from Vocabulary v", VocabularyDTO.class)
                        .getResultList()
        );
    }

    @Override
    public Optional<VocabularyDTO> findOne(Integer id) {
        return entityManager.unwrap(Session.class).createQuery("select new com.buimanhthanh.englishappapi.dto.VocabularyDTO(v.id,v.vocabulary,v.phonetic,v.mean,v.audio,v.image,v.exampleSentences,v.meaningExp,v.topicByTopicIdVocabulary.id) from Vocabulary v where v.id =: i")
                .setParameter("i", id).stream().findFirst();
    }

    @Override
    public boolean saveOrUpdate(Vocabulary vocabulary) {
        try {
            entityManager.unwrap(Session.class).saveOrUpdate(vocabulary);
            return true;
        } catch (HibernateException e) {
            System.out.println("Can not save or update vocabulary");
        }
        return false;
    }

    @Override
    public void saveOrUpdate(List<Vocabulary> vocabularies) {
        vocabularies.forEach(this::saveOrUpdate);
    }

    @Override
    public void delete(Integer id) {
        entityManager.unwrap(Session.class).createQuery("delete from Vocabulary v where v.id =: i").setParameter("i", id).executeUpdate();
    }

    @Override
    public void delete(List<Integer> ids) {
        ids.forEach(this::delete);
    }
}
