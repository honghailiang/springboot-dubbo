package com.jtt.hhl.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jtt.hhl.service.TestDubboService;

/**
 * @Description: java类作用描述
 * @Author: Herman
 * @CreateDate: 2019/1/5 10:52
 */
@Service(version = "1.0.0")
public class TestDubboServiceImpl implements TestDubboService {
    @Override
    public String testDubboService(String arg) {
        return arg;
    }
}
