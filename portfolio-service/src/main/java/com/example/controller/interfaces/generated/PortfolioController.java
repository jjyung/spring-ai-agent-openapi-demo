package com.example.controller.interfaces.generated;

import com.example.model.dto.generated.portfolio.GetPortfolioResponseDTO;
import com.example.model.dto.generated.portfolio.PutPortfollioRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PortfolioController implements PortfolioApi {
    private static final Map<String, Map<String, Integer>> ACCOUNT_PORTFOLIO = new HashMap<>();

    @Override
    public ResponseEntity<List<GetPortfolioResponseDTO>> getApiPortfolio(String account) {
        log.info("查詢庫存: account={}", account);
        var portfolio = ACCOUNT_PORTFOLIO.computeIfAbsent(account, k -> new HashMap<>());
        //
        var responseList = portfolio.entrySet().stream().map(entry -> {
            var dto = new GetPortfolioResponseDTO();
            dto.setProductId(entry.getKey());
            dto.setCount(entry.getValue());
            return dto;
        }).toList();

        return ResponseEntity.ok(responseList);
    }

    @Override
    public ResponseEntity<Void> putApiPortfolioAccount(String account, PutPortfollioRequestDTO putPortfollioRequestDTO) {
        log.info("修改庫存: account={}, putPortfollioRequestDTO={}", account, putPortfollioRequestDTO);
        var portfolio = ACCOUNT_PORTFOLIO.computeIfAbsent(account, k -> new HashMap<>());
        var count = portfolio.getOrDefault(putPortfollioRequestDTO.getProductId(), 0);
        portfolio.put(putPortfollioRequestDTO.getProductId(), count + putPortfollioRequestDTO.getCount());

        return ResponseEntity.ok().build();
    }
}
