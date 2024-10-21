package com.example.test.config;
import org.springframework.cloud.openfeign.EnableFeignClients;

import org.springframework.cloud.openfeign.aot.FeignChildContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients
public class FeignConfig {

}