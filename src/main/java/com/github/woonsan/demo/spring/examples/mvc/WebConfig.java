package com.github.woonsan.demo.spring.examples.mvc;

import static org.apache.freemarker.core.Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS;

import org.apache.freemarker.core.templateresolver.TemplateLoader;
import org.apache.freemarker.spring.SpringResourceTemplateLoader;
import org.apache.freemarker.spring.web.view.FreeMarkerViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(viewResolver());
    }

    @Bean
    public ViewResolver viewResolver() {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setConfiguration(configuration());
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".ftl");
        return resolver;
    }

    @Bean
    public org.apache.freemarker.core.Configuration configuration() {
        return new org.apache.freemarker.core.Configuration.Builder(DEFAULT_INCOMPATIBLE_IMPROVEMENTS)
                .templateUpdateDelayMilliseconds(5000L)
                .localizedTemplateLookup(false)
                .templateLoader(templateLoader())
                .build();
    }

    @Bean
    public TemplateLoader templateLoader() {
        return new SpringResourceTemplateLoader();
    }
}
