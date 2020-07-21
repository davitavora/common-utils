package com.github.davitavorah.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.bohnman.squiggly.Squiggly;
import com.github.bohnman.squiggly.web.RequestSquigglyContextProvider;
import com.github.bohnman.squiggly.web.SquigglyRequestFilter;
import com.github.davitavorah.common.filter.AllowCustomHeadersFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(CommonProperty.class)
public class CommonUtilsAutoConfiguration {

    private final CommonProperty commonProperty;

    @Bean
    @ConditionalOnProperty("common.utils.enable-squiggly")
    public FilterRegistrationBean<SquigglyRequestFilter> squigglyRequestFilterRegistration(ObjectMapper objectMapper) {
        Squiggly.init(objectMapper, new RequestSquigglyContextProvider(commonProperty.getSquigglyQueryParam(), null));
        var filterRegistration = new FilterRegistrationBean<SquigglyRequestFilter>();
        filterRegistration.setFilter(new SquigglyRequestFilter());
        filterRegistration.setOrder(1);
        return filterRegistration;
    }

    @Bean
    public FilterRegistrationBean<AllowCustomHeadersFilter> customResponseFilterRegistration() {
        var filterRegistration = new FilterRegistrationBean<AllowCustomHeadersFilter>();
        filterRegistration.setFilter(new AllowCustomHeadersFilter());
        filterRegistration.setOrder(2);
        return filterRegistration;
    }

}
