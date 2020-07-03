package com.github.davitavorah.common.configuration;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

@Configuration
@NoArgsConstructor
public class ExecutorServiceConfiguration {

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_APPLICATION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public ExecutorService createExecutorServicesPool() {
        return newFixedThreadPool(10, new ThreadFactoryBuilder().setNameFormat("THREAD-%d").build());
    }
}
