package com.micah.goods_example.config;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class WebConfig {

    /**
     * 文件命名
     * @return 文件
     */
    @Bean
    public TomcatServletWebServerFactory webServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.addConnectorCustomizers((Connector connector) -> {
            connector.setProperty("relaxedPathChars", "\"<>[\\]^`{|}");
            connector.setProperty("relaxedQueryChars", "\"<>[\\]^`{|}");
        });
        return factory;
    }

    /**
     * 配置跨域
     * @return 跨域
     */
    private CorsConfiguration corsConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedOrigin("https://a.micah6.xyz:8000");
        corsConfiguration.addAllowedOrigin("https://micah.fun:81");
        corsConfiguration.addAllowedOrigin("http://127.0.0.1");
        corsConfiguration.addAllowedOrigin("http://127.0.0.1:8080");
        corsConfiguration.addAllowedOrigin("http://localhost");
        corsConfiguration.addAllowedOrigin("http://localhost:8080");
        corsConfiguration.addAllowedOrigin("http://localhost:8081");
        corsConfiguration.addAllowedOrigin("http://127.0.0.1:8081");
        corsConfiguration.addAllowedOrigin("http://127.0.0.1:88");
        corsConfiguration.addAllowedOrigin("http://localhost:88");
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setAllowCredentials(true);
        return corsConfiguration;
    }
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig());
        return new CorsFilter(source);
    }
}
