package com.buimanhthanh.englishappapi.controller.api;

import com.buimanhthanh.englishappapi.dto.AccountDTO;
import com.buimanhthanh.englishappapi.dto.ResponseObject;
import com.buimanhthanh.englishappapi.entity.Account;
import com.buimanhthanh.englishappapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/account")
public class AccountAPI {

    @Autowired
    private AccountService accountService;

    @GetMapping("")
    public ResponseEntity<ResponseObject> loadAccount() {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Query lesson success", accountService.findAll().get())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> loadOneAccount(@PathVariable Integer id) {
        Optional<AccountDTO> foundAccount = accountService.findOne(id);
        return foundAccount.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok", "Query account success", foundAccount.get())
                ) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("failed", "Cannot found account by id " + id, "")
                );
    }

    @PostMapping("")
    public ResponseEntity<ResponseObject> addAccount(@RequestBody Account account) {
        account.setId(null);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert Account successfully", accountService.saveOrUpdate(account))
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> updateAccount(@RequestBody Account newAccount, @PathVariable Integer id) {
        newAccount.setId(id);
        Optional<AccountDTO> foundAccount = accountService.findOne(id);
        return foundAccount.isEmpty() ?
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("failed", "Not found account with id : " + id, false)
                ) :
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok", "Update Account successfully", accountService.saveOrUpdate(newAccount))
                );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> deleteAccount(@PathVariable Integer id) {
        accountService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "delete successfully", true)
        );
    }
}
