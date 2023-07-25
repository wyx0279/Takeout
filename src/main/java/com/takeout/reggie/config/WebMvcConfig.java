package com.takeout.reggie.config;

import com.takeout.reggie.common.JacksonObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@Slf4j
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    /**
     * 设置静态资源映射
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        log.info("设置静态资源映射.....");
    }

    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        //创建消息转换器
        MappingJackson2HttpMessageConverter messageConverter  = new MappingJackson2HttpMessageConverter();
        //设置具体对象映射器
        messageConverter.setObjectMapper(new JacksonObjectMapper());
        //设置索引让自己的转换器放在最前面，否则会使用默认放在前面的转换器
        converters.add(0,messageConverter);
    }
}