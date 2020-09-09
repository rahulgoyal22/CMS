package com.sample.cash.management.system.model.Request;

import com.sample.cash.management.system.entity.Hotel;
import com.sample.cash.management.system.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddTransactionRequest {

    private TransactionType transaction;
    private double amount;
}
