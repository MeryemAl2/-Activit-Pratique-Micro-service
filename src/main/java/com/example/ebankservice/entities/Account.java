package com.example.ebankservice.entities;

import com.example.ebankservice.enums.AccountType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Builder
public class Account {
    @Id
    private String id;
    private String currency;
    private double balance;
    private Date createdAt;
    private AccountType type;
}
