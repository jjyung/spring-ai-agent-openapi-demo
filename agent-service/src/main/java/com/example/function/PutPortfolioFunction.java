package com.example.function;

import com.example.client.PortfolioApiClient;
import com.example.model.dto.generated.portfolio.GetPortfolioResponseDTO;
import com.example.model.dto.generated.portfolio.PutPortfollioRequestDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Function;

@Slf4j
@RequiredArgsConstructor
public class PutPortfolioFunction
        implements Function<PutPortfolioFunction.Request, PutPortfolioFunction.Response> {
    private final PortfolioApiClient client;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        @JsonProperty(required = true)
        @JsonPropertyDescription("使用者帳號, 帳號格式前三碼固定為ABC, 後七碼為任意數字")
        String account;

        @JsonProperty(required = true)
        @JsonPropertyDescription("股票代碼, 只能為四碼數字")
        String productId;

        @JsonProperty(required = true)
        @JsonPropertyDescription("購買數量, 不得小於0")
        Integer count;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        @JsonPropertyDescription("是否成功, true: 成功, false: 失敗")
        Boolean success;
    }

    public Response apply(Request request) {
        try {
            var requestDTO = new PutPortfollioRequestDTO();
            requestDTO.setProductId(request.getProductId());
            requestDTO.setCount(request.getCount());
            var responseDTO = client.putApiPortfolioAccount(request.getAccount(), requestDTO);
            return new Response(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
