package com.sample.cash.management.system.model.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sample.cash.management.system.entity.Hotel;
import com.sample.cash.management.system.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionResponse {

    private String managerId;
    private TransactionType transaction;
    private double amount;
}
