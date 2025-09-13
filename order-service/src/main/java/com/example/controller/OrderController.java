package com.example.controller;

import com.example.controller.interfaces.generated.OrderApi;

import com.example.model.dto.order.generated.BuyRequestDTO;
import com.example.model.dto.order.generated.CommonResponseDTO;
import com.example.model.dto.order.generated.SellRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class OrderController implements OrderApi {

    @Override
    public ResponseEntity<CommonResponseDTO> postApiBuy(BuyRequestDTO buyRequestDTO) throws Exception {
        var responseDTO = new CommonResponseDTO();
        responseDTO.setMessage("success.");
        responseDTO.setReturnCode("0000");

        return ResponseEntity.ok(responseDTO);
    }

    @Override
    public ResponseEntity<CommonResponseDTO> postApiSell(SellRequestDTO sellRequestDTO) throws Exception {
        var responseDTO = new CommonResponseDTO();
        responseDTO.setMessage("success.");
        responseDTO.setReturnCode("0000");

        return ResponseEntity.ok(responseDTO);
    }
}