package br.mackenzie.apd3.loja.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BWeninger on 11/04/2015.
 */
@Configuration
public class JSONConfig {

    private List<HttpMessageConverter<?>> getMessageConverters(){
        List<HttpMessageConverter<?>> list = new ArrayList<>();
        list.add(new MappingJackson2HttpMessageConverter());
        return list;
    }

    @Bean
    public RequestMappingHandlerAdapter geRequestMappingHandlerAdapter(){
        RequestMappingHandlerAdapter adapter = new RequestMappingHandlerAdapter();
        adapter.setMessageConverters(getMessageConverters());
        return adapter;
    }
}
