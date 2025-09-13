package com.example.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class AiFunctionManager {

    private final ToolCallback orderBuyFunctionToolCallback;
    private final ToolCallback orderSellFunctionToolCallback;
    private final ToolCallback accountInquiryFunctionToolCallback;
    private final ToolCallback queryPortfolioFunctionToolCallback;
    private final ToolCallback putPortfolioFunctionToolCallback;

    public List<ToolCallback> getAllFunctionCallback() {
        return List.of(orderBuyFunctionToolCallback, orderSellFunctionToolCallback, accountInquiryFunctionToolCallback, queryPortfolioFunctionToolCallback,putPortfolioFunctionToolCallback);
    }
}
