package cn.fighter3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
/**
 * @Author Cxb
 * @Date 2021-03-26 13:52
 */
@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //允许所有源 Origin
        corsConfiguration.addAllowedOrigin("*");
        //允许所有头部 header
        corsConfiguration.addAllowedHeader("*");
        //允许所有方法Method
        corsConfiguration.addAllowedMethod("*");
        source.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsFilter(source);


    }

}
