package com.example.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="${order.name:order}", url="${order.url:http://localhost:8082}")
public interface OrderApiClient extends OrderApi {
}
