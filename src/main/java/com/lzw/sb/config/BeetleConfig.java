package com.lzw.sb.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;

//@Configuration  
public class BeetleConfig {
//	@Bean(initMethod = "init", name = "beetlConfig")
//    public BeetlGroupUtilConfiguration getBeetlGroupUtilConfiguration() {
//        BeetlGroupUtilConfiguration beetlGroupUtilConfiguration = new BeetlGroupUtilConfiguration();
//        ResourcePatternResolver patternResolver = ResourcePatternUtils.getResourcePatternResolver(new DefaultResourceLoader());
//        WebAppResourceLoader webAppResourceLoader;
//		try {
//			webAppResourceLoader = new WebAppResourceLoader(patternResolver.getResource("classpath:/templates").getFile().getPath());
//			 beetlGroupUtilConfiguration.setResourceLoader(webAppResourceLoader);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//读取配置文件信息
//        beetlGroupUtilConfiguration.setConfigFileResource(patternResolver.getResource("classpath:/config/beetl.properties"));
//        return beetlGroupUtilConfiguration;
//    }
//    @Bean(name = "beetlViewResolver")
//    public BeetlSpringViewResolver getBeetlSpringViewResolver() {
//        BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
//        beetlSpringViewResolver.setPrefix("/");
//        beetlSpringViewResolver.setSuffix(".html");
//        beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
//        beetlSpringViewResolver.setOrder(0);
//        beetlSpringViewResolver.setConfig(getBeetlGroupUtilConfiguration());
//        return beetlSpringViewResolver;
//    }
}
