package com.jtt.hhl.config;

import com.jtt.hhl.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: java类作用描述
 * @Author: Herman
 * @CreateDate: 2019/1/14 11:50
 */
@Configuration
public class ConfigTest {

    public ConfigTest() {
        System.out.println("====testConfig");
    }

    @Bean
    public Person person(){
        return new Person();
    }
}
