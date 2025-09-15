package com.example.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="${account.name:account}", url="${account.url:http://localhost:8081}")
public interface AccountApiClient extends AccountApi {
}
