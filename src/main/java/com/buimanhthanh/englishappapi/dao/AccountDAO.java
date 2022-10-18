package com.buimanhthanh.englishappapi.dao;

import com.buimanhthanh.englishappapi.dto.AccountDTO;
import com.buimanhthanh.englishappapi.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountDAO {
    Optional<List<AccountDTO>> findAll();
    Optional<AccountDTO> findOne(Integer id);
    boolean saveOrUpdate(Account account);
    void saveOrUpdate(List<Account> accounts);
    void delete(Integer id);
    void delete(List<Integer> ids);
}
