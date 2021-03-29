package cn.fighter3.config;

import cn.fighter3.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author Cxb
 * @Date 2021-03-26 11:25
 */

@Configuration
public class DemoWebConfig  implements WebMvcConfigurer {


    public void addInterceptors(InterceptorRegistry registry){
        //添加拦截器
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("api/**")
                //将。。。除外；不包括   登录页面除外
                .excludePathPatterns("/api/login");

    }
}
