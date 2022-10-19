package com.buimanhthanh.englishappapi.service;

import com.buimanhthanh.englishappapi.dto.AccountDTO;
import com.buimanhthanh.englishappapi.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    Optional<AccountDTO> getAccountByUsername(String username);
    Optional<List<AccountDTO>> findAll();

    Optional<AccountDTO> findOne(Integer id);

    boolean saveOrUpdate(Account account);

    void saveOrUpdate(List<Account> accounts);

    void delete(Integer id);

    void delete(List<Integer> ids);
}
