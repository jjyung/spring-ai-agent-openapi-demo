package com.example.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="${portfolio.name:portfolio}", url="${portfolio.url:http://localhost:8083}")
public interface PortfolioApiClient extends PortfolioApi {
}
