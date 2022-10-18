package com.buimanhthanh.englishappapi.controller;

import com.buimanhthanh.englishappapi.entity.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HomeController {

    @GetMapping("/test/{id}")
    public List<Account> test(@PathVariable Integer id) {
        List accounts =
                List.of(new Account(null, "Thành", "123", "Bùi Mạnh Thành", "manhthanh147@gmail.com", null, null, null),
                        new Account(null, "Thành1", "123", "Bùi Mạnh Thành1", "manhthanh147@gmail.com", null, null, null),
                        new Account(null, "Thành2", "123", "Bùi Mạnh Thành2", "manhthanh147@gmail.com", null, null, null),
                        new Account(null, "Thành3", "123", "Bùi Mạnh Thành3", "manhthanh147@gmail.com", null, null, null));
        return accounts;
    }


}
