package com.aimobier.config;

import com.aimobier.util.PathUtil;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.MultipartConfigElement;

@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter{

    /**
     * 文件上传临时路径
     */
    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation(PathUtil.UPLOAD_TMP_FILE_PATH());
        return factory.createMultipartConfig();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("index").setViewName("index.html");
        registry.addViewController("console").setViewName("console.html");

        super.addViewControllers(registry);
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        super.configurePathMatch(configurer);
        configurer.setUseSuffixPatternMatch(false);
    }
}