package com.bangbangtu.couponsserver.config;

import javafx.beans.property.adapter.JavaBeanBooleanPropertyBuilder;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate 配置文件
 *
 * @author Administrator
 */
@Configuration
@ConditionalOnClass(value = {RestTemplate.class, HttpClient.class})
public class RestTemplateConfiguration {

    @Bean
    public HttpClientConnectionManager poolingConnectionManager() {
        PoolingHttpClientConnectionManager poolingConnectionManager = new PoolingHttpClientConnectionManager();
        // 连接池最大连接数
        poolingConnectionManager.setMaxTotal(1000);
        // 每个主机的并发
        poolingConnectionManager.setDefaultMaxPerRoute(500);
        return poolingConnectionManager;
    }

    @Bean
    public HttpClientBuilder httpClientBuilder() {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        // 设置HTTP连接管理器
        httpClientBuilder.setConnectionManager(poolingConnectionManager());
        return httpClientBuilder;
    }

    @Bean("restTemplate")
    @ConditionalOnMissingBean(RestTemplate.class)
    public RestTemplate restTemplate() {
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClientBuilder().build());
        // 获取链接超时时间
        requestFactory.setConnectionRequestTimeout(3000);
        // 指客户端和服务器建立连接的timeout
        requestFactory.setConnectTimeout(3000);
        // 读取数据的超时时间
        requestFactory.setReadTimeout(120000);
        return new RestTemplate(requestFactory);
    }
}
