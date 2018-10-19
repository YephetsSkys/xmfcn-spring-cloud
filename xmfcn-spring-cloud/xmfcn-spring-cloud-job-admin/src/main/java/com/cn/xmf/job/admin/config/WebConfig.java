package com.cn.xmf.job.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * web 配置
 * @author quyuanchao
 * @date 2018-8-23 17:47
 * <p>Title: com.xxl.job.admin.config</p>
 * <p>Description: $DESCRIPTION</p>
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自定义拦截器，添加拦截路径和排除拦截路径
        //registry.addInterceptor(new PermissionInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new XmfInterceptor()).addPathPatterns("/**");
    }
}
