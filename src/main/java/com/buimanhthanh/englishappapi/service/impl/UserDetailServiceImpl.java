package com.buimanhthanh.englishappapi.service.impl;

import com.buimanhthanh.englishappapi.dao.AccountDAO;
import com.buimanhthanh.englishappapi.dto.AccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private AccountDAO accountDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AccountDTO> account = accountDAO.getAccountByUsername(username);
        if (account.isEmpty())
            throw new UsernameNotFoundException("ncc");
        return account.get();
    }
}
