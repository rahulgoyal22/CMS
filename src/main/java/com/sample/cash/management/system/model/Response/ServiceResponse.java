package com.sample.cash.management.system.model.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sample.cash.management.system.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ServiceResponse {
    private Status status;

    private String message;
}
