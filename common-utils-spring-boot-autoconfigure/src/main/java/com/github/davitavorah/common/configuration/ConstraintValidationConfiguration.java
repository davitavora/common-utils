package com.github.davitavorah.common.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class ConstraintValidationConfiguration {

    @Autowired
    public void configMessageSource(LocalValidatorFactoryBean localValidatorFactoryBean) {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:ValidationMessages");
        messageSource.setDefaultEncoding("UTF-8");
        localValidatorFactoryBean.setValidationMessageSource(messageSource);
    }

}
