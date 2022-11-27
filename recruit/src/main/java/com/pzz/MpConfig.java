package com.pzz;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MpConfig {
    @Bean
    public MybatisPlusInterceptor myInterceptor(){
        MybatisPlusInterceptor myInterceptor = new MybatisPlusInterceptor();
        myInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return myInterceptor;
    }
}
