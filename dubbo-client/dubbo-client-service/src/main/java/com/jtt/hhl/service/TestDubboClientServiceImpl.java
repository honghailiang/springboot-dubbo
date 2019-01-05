package com.jtt.hhl.service;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @Description: java类作用描述
 * @Author: Herman
 * @CreateDate: 2019/1/5 13:58
 */
@Service
public class TestDubboClientServiceImpl implements TestDubboClientService{

    @Reference(version = "1.0.0")
    TestDubboService testDubboService;

    @Override
    public String testDubboClientService(String arg) {
        return testDubboService.testDubboService(arg);
    }
}
