package com.example.controller;

import com.example.client.AccountApiClient;
import com.example.client.PortfolioApiClient;
import com.example.controller.interfaces.generated.OrderApi;
import com.example.model.dto.generated.account.PutInquiryRequestDTO;
import com.example.model.dto.generated.order.BuyRequestDTO;
import com.example.model.dto.generated.order.CommonResponseDTO;
import com.example.model.dto.generated.order.SellRequestDTO;
import com.example.model.dto.generated.portfolio.PutPortfollioRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@Slf4j
public class OrderController implements OrderApi {
    private static final Map<String, BigDecimal> ORDER_PRICE = Map.of("2330", BigDecimal.valueOf(1000), "0050", BigDecimal.valueOf(200), "00878", BigDecimal.valueOf(20));

    private final AccountApiClient accountApiClient;
    private final PortfolioApiClient portfolioApiClient;

    @Override
    public ResponseEntity<CommonResponseDTO> postApiBuy(BuyRequestDTO buyRequestDTO) {
        log.info("下單買入: 帳號={}, 代碼={}, 數量={}", buyRequestDTO.getAccount(), buyRequestDTO.getProductId(), buyRequestDTO.getCount() );
        var responseDTO = new CommonResponseDTO();

        if (!ORDER_PRICE.containsKey(buyRequestDTO.getProductId())) {
            responseDTO.setMessage("無此股票代號");
            responseDTO.setReturnCode("9999");
            return ResponseEntity.ok(responseDTO);
        }
        // 取得總額並變成負數
        var price = ORDER_PRICE.get(buyRequestDTO.getProductId())
                .multiply(BigDecimal.valueOf(buyRequestDTO.getCount())).negate();

        // 呼叫增加帳戶庫存
        this.callPortfolio(buyRequestDTO.getAccount(), buyRequestDTO.getProductId(), buyRequestDTO.getCount());
        // 呼叫扣除帳戶餘額
        this.callAccount(buyRequestDTO.getAccount(), price);

        responseDTO.setMessage("success.");
        responseDTO.setReturnCode("0000");
        return ResponseEntity.ok(responseDTO);
    }

    @Override
    public ResponseEntity<CommonResponseDTO> postApiSell(SellRequestDTO sellRequestDTO) {
        log.info("下單賣出: 帳號={}, 代碼={}, 數量={}", sellRequestDTO.getAccount(), sellRequestDTO.getProductId(), sellRequestDTO.getCount() );
        var responseDTO = new CommonResponseDTO();

        if (!ORDER_PRICE.containsKey(sellRequestDTO.getProductId())) {
            responseDTO.setMessage("無此股票代號");
            responseDTO.setReturnCode("9999");
            return ResponseEntity.ok(responseDTO);
        }
        // 取得總額並變成負數
        var price = ORDER_PRICE.get(sellRequestDTO.getProductId())
                .multiply(BigDecimal.valueOf(sellRequestDTO.getCount()));
        // 呼叫扣除帳戶庫存
        this.callPortfolio(sellRequestDTO.getAccount(), sellRequestDTO.getProductId(), -sellRequestDTO.getCount());
        // 呼叫增加帳戶餘額
        this.callAccount(sellRequestDTO.getAccount(), price);

        responseDTO.setMessage("success.");
        responseDTO.setReturnCode("0000");
        return ResponseEntity.ok(responseDTO);
    }

    private void callAccount(String account, BigDecimal amount) {
        var requestDTO = new PutInquiryRequestDTO();
        requestDTO.setAmount(amount);

        try {
            accountApiClient.putApiInquiryAccount(account, requestDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void callPortfolio(String account, String productId, Integer count) {
        var requestDTO = new PutPortfollioRequestDTO();
        requestDTO.setProductId(productId);
        requestDTO.setCount(count);

        try {
            portfolioApiClient.putApiPortfolioAccount(account, requestDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}