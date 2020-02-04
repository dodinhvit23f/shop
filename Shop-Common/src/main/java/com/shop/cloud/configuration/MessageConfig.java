
package com.shop.cloud.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class MessageConfig {

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
	ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource(); // Tải file:
	messageSource.setBasename("classpath:message");
	messageSource.setCacheSeconds(10); //reload messages every ... seconds
	messageSource.setUseCodeAsDefaultMessage(true);
	messageSource.setDefaultEncoding("UTF-8");
	return messageSource;
    }
    
    @Bean
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }

  
}
