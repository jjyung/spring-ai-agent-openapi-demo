package com.example.function;

import com.example.client.AccountApiClient;
import com.example.client.PortfolioApiClient;
import com.example.model.dto.generated.portfolio.GetPortfolioResponseDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;

@Slf4j
@RequiredArgsConstructor
public class QueryPortfolioFunction
        implements Function<QueryPortfolioFunction.Request, QueryPortfolioFunction.Response> {
    private final PortfolioApiClient client;

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
        @JsonPropertyDescription("庫存狀況資訊")
        List<GetPortfolioResponseDTO> portfolio;
    }

    public Response apply(Request request) {
        try {
            var responseDTO = client.getApiPortfolio(request.getAccount());
            return new Response(responseDTO.getBody());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
