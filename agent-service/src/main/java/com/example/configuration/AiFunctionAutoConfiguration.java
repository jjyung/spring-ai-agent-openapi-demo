package com.example.configuration;


import com.example.client.OrderApiClient;
import com.example.function.OrderBuyFunction;
import com.example.function.OrderSellFunction;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.function.FunctionToolCallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AiFunctionAutoConfiguration {
    private final OrderApiClient orderApiClient;

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
                .inputType(OrderBuyFunction.Request.class)
                .build();
    }

}
