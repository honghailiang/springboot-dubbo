package com.jtt.hhl.service;

import com.jtt.hhl.bean.User;

/**
 * @Description: dubbo提供rest服务类
 * @Author: Herman
 * @CreateDate: 2019/1/30 16:50
 */

//@Path("users")
//@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
//@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public interface TestDubboRestService {

    //@GET
    //@Path("{id: \\d+}")
    User getUser(/**@PathParam("id")*/ Long id);

    //@POST
    //@Path("register")
    Long registerUser(User user);
}
