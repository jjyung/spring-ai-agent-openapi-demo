package com.example.function;

import com.example.client.AccountApiClient;
import com.example.client.OrderApiClient;
import com.example.model.dto.generated.order.BuyRequestDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.function.Function;

@Slf4j
@RequiredArgsConstructor
public class AccountFunction
        implements Function<AccountFunction.Request, AccountFunction.Response> {
    private final AccountApiClient client;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        @JsonProperty(required = true)
        @JsonPropertyDescription("使用者帳號, 帳號格式前三碼固定為ABC, 後七碼為任意數字")
        String account;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        @JsonPropertyDescription("使用者帳戶餘額")
        BigDecimal inquiry;
    }

    public Response apply(Request request) {
        try {
            var responseDTO = client.getApiInquiry(request.getAccount());
            return new Response(responseDTO.getBody().getAmount());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
