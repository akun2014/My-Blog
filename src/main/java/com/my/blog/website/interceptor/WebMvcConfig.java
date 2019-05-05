package com.my.blog.website.interceptor;


import com.my.blog.website.utils.TaleUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 向mvc中添加自定义组件
 * Created by BlueT on 2017/3/9.
 */
@Component
public class WebMvcConfig implements WebMvcConfigurer {
    @Resource
    private BaseInterceptor baseInterceptor;

    private static final List<String> EXCLUDE_PATTERN = new ArrayList<>();

    static {
        EXCLUDE_PATTERN.add("/**/**.css");
        EXCLUDE_PATTERN.add("/**/**.js");
        EXCLUDE_PATTERN.add("/**/**.png");
        EXCLUDE_PATTERN.add("/**/**.gif");
        EXCLUDE_PATTERN.add("/**/**.jpg");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(baseInterceptor).excludePathPatterns(EXCLUDE_PATTERN);
    }

    /**
     * 添加静态资源文件，外部可以直接访问地址
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:" + TaleUtils.getUploadFilePath() + "upload/");
    }
}
