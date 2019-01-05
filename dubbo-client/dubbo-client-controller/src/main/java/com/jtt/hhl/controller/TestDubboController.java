package com.jtt.hhl.controller;

import com.jtt.hhl.service.TestDubboClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: java类作用描述
 * @Author: Herman
 * @CreateDate: 2019/1/5 13:52
 */
@RestController
public class TestDubboController {

    @Autowired
    private TestDubboClientService testDubboClientService;

    @RequestMapping("/testdubbo")
    public String testDubbo(String arg){
        return testDubboClientService.testDubboClientService(arg);
    }
}
