package com.example.controller.interfaces.generated;

import org.springframework.cloud.openfeign.FeignClient;
import org.openapitools.configuration.ClientConfiguration;

@FeignClient(name="${order.name:order}", url="${order.url:http://localhost:3000}", configuration = ClientConfiguration.class)
public interface OrderApiClient extends OrderApi {
}
