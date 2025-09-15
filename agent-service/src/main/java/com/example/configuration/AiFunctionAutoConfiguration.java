package com.example.configuration;


import com.example.client.AccountApiClient;
import com.example.client.OrderApiClient;
import com.example.client.PortfolioApiClient;
import com.example.function.*;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.function.FunctionToolCallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AiFunctionAutoConfiguration {
    private final OrderApiClient orderApiClient;
    private final AccountApiClient accountApiClient;
    private final PortfolioApiClient portfolioApiClient;

    @Bean
    public ToolCallback orderBuyFunctionToolCallback() {
        return FunctionToolCallback
                .builder("orderBuy", new OrderBuyFunction(orderApiClient))
                .description("下單買進股票") // function 描述
                // 二選一：用 inputType 讓框架自動生 JSON Schema，或自己給 inputSchema(JSON 字串)
                .inputType(OrderBuyFunction.Request.class)
                .build();
    }

    @Bean
    public ToolCallback orderSellFunctionToolCallback() {
        return FunctionToolCallback
                .builder("orderSell", new OrderSellFunction(orderApiClient))
                .description("下單賣出股票") // function 描述
                .inputType(OrderSellFunction.Request.class)
                .build();
    }

    @Bean
    public ToolCallback accountInquiryFunctionToolCallback() {
        return FunctionToolCallback
                .builder("accountInquiry", new AccountFunction(accountApiClient))
                .description("查詢帳號餘額") // function 描述
                .inputType(AccountFunction.Request.class)
                .build();
    }

    @Bean
    public ToolCallback queryPortfolioFunctionToolCallback() {
        return FunctionToolCallback
                .builder("queryPortfolio", new QueryPortfolioFunction(portfolioApiClient))
                .description("查詢帳號股票庫存") // function 描述
                .inputType(QueryPortfolioFunction.Request.class)
                .build();
    }

    @Bean
    public ToolCallback putPortfolioFunctionToolCallback() {
        return FunctionToolCallback
                .builder("putPortfolio", new PutPortfolioFunction(portfolioApiClient))
                .description("更新帳號股票庫存") // function 描述
                .inputType(PutPortfolioFunction.Request.class)
                .build();
    }




}
