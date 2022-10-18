package com.buimanhthanh.englishappapi.dao.impl;

import com.buimanhthanh.englishappapi.dao.AccountDAO;
import com.buimanhthanh.englishappapi.dto.AccountDTO;
import com.buimanhthanh.englishappapi.entity.Account;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Optional<List<AccountDTO>> findAll() {
//        CriteriaBuilder cb = session.getCurrentSession().getCriteriaBuilder();
//        CriteriaQuery<Account> cq = cb.createQuery(Account.class);
//        Root<Account> rootEntry = cq.from(Account.class);
//        CriteriaQuery<Account> all = cq.select(rootEntry);
//
//        TypedQuery<Account> allQuery = session.getCurrentSession().createQuery(all);
//        return Optional.ofNullable(allQuery.getResultList());
        return Optional.ofNullable(entityManager.unwrap(Session.class).createQuery("select new com.buimanhthanh.englishappapi.dto.AccountDTO(a.id,a.username,a.password,a.fullName,a.email) from Account a", AccountDTO.class)
                .getResultList());
    }

    @Override
    public Optional<AccountDTO> findOne(Integer id) {
        return entityManager.unwrap(Session.class).createQuery("select new com.buimanhthanh.englishappapi.dto.AccountDTO(a.id,a.username,a.password,a.fullName,a.email) from Account a where a.id =: i",AccountDTO.class)
                .setParameter("i",id).getResultList().stream().findFirst();
    }

    @Override
    public boolean saveOrUpdate(Account account) {
        try {
            entityManager.unwrap(Session.class).saveOrUpdate(account);
            return true;
        }catch (HibernateException e){
            System.out.println("ERROR WHEN ADD ACCOUNT : " + e.getMessage());
        }
        return false;
    }

    @Override
    public void saveOrUpdate(List<Account> accounts) {
        accounts.forEach(this::saveOrUpdate);
    }

    @Override
    public void delete(Integer id) {
        entityManager.unwrap(Session.class).createQuery("delete from Account a where a.id =: i").setParameter("i",id).executeUpdate();
    }

    @Override
    public void delete(List<Integer> ids) {
        ids.forEach(this::delete);
    }
}
