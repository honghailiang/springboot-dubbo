package com.jtt.hhl.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jtt.hhl.bean.User;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description: java类作用描述
 * @Author: Herman
 * @CreateDate: 2019/1/30 17:02
 */
@Service(version = "1.0.0")
public class TestDubboRestServiceImpl implements TestDubboRestService {
    private final AtomicLong id = new AtomicLong();

    @Override
    public User getUser(Long id) {
        return new User(id, "username-" + id);
    }

    @Override
    public Long registerUser(User user) {
        return id.incrementAndGet();
    }
}
