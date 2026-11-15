package com.example.ebankservice.web;

import com.example.ebankservice.entities.Account;
import com.example.ebankservice.repositories.AccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class AccountRest {

    private AccountRepository accountRepository;

    public AccountRest(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/bankAccounts")
    public List<Account> bankAccounts() {
        return accountRepository.findAll();
    }

    @GetMapping("/bankAccounts/(id}")
    public Account account(@PathVariable String id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account %s not found", id)));
    }

    @PostMapping("/bankAccounts")
    public Account save(@RequestBody Account bankAccount) {
        return accountRepository.save(bankAccount);
    }

    @PutMapping("/bankAccounts/{id}")
    public Account update(@PathVariable String id, @RequestBody Account account) {
        Account bankAccount = accountRepository.findById(id).orElseThrow();
        if (account.getBalance() != 0) bankAccount.setBalance(account.getBalance());
        if (account.getCreatedAt() != null) bankAccount.setCreatedAt(new Date());
        if (account.getType() != null) bankAccount.setType(account.getType());
        if (account.getCurrency() != null) bankAccount.setCurrency(account.getCurrency());
        return accountRepository.save(account);
    }

    @DeleteMapping("/bankAccounts/{id)")
    public void deleteAccount(@PathVariable String id){
        accountRepository.deleteById(id);
    }
}
