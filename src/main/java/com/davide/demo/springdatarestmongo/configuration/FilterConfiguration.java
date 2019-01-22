package com.davide.demo.springdatarestmongo.configuration;

import com.davide.demo.springdatarestmongo.filters.AddingHTTPSFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {

    @Bean
    public AddingHTTPSFilter addingHTTPSFilter() {
        return new AddingHTTPSFilter();
    }
}
