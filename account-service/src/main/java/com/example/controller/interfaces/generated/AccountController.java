package com.example.controller.interfaces.generated;

import com.example.model.dto.generated.account.CommonResponseDTO;
import com.example.model.dto.generated.account.GetInquiryResponseDTO;
import com.example.model.dto.generated.account.PutInquiryRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AccountController implements AccountApi {
    private static final Map<String, BigDecimal> ACCOUNT_BALANCE = new HashMap<>();

    @Override
    public ResponseEntity<GetInquiryResponseDTO> getApiInquiry(String account) {
        log.info("查詢餘額: account={}", account);
        var responseDTO = new GetInquiryResponseDTO();
        // 新帳號送五萬
        responseDTO.setAmount(ACCOUNT_BALANCE.computeIfAbsent(account, k ->  BigDecimal.valueOf(50000)));
        return ResponseEntity.ok(responseDTO);
    }

    @Override
    public ResponseEntity<CommonResponseDTO> putApiInquiryAccount(String account, PutInquiryRequestDTO requestDTO) throws Exception {
        log.info("修改餘額: account={}, 修改金額={}", account, requestDTO.getAmount().toBigInteger());

        var accountBalance = ACCOUNT_BALANCE.computeIfAbsent(account, k -> BigDecimal.valueOf(50000));
        accountBalance = accountBalance.add(requestDTO.getAmount());
        ACCOUNT_BALANCE.put(account, accountBalance);

        var responseDTO = new CommonResponseDTO();
        responseDTO.setMessage("success.");
        responseDTO.setReturnCode("0000");
        return ResponseEntity.ok(responseDTO);
    }
}
