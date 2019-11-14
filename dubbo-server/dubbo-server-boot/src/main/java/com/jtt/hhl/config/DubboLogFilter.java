package com.jtt.hhl.config;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.rpc.*;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

/**
 * @Description: 日志filter
 * @Author: Herman
 * @CreateDate: 2019/11/14 14:31
 */
@Slf4j
public class DubboLogFilter implements Filter {
    public static final String TRACE_ID = "TRACE_ID";

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        long start = System.currentTimeMillis();

        //dubbo消费者
        if (RpcContext.getContext().isConsumerSide()) {
            String traceId = MDCUtil.get(MDCUtil.Type.TRACE_ID);
            if (StringUtils.isBlank(traceId)) {
                traceId = UUID.randomUUID().toString().replaceAll("-", "");
            }
            //设置traceid
            RpcContext.getContext().setAttachment(TRACE_ID, traceId);
        }
        //dubbo提供者
        if (RpcContext.getContext().isProviderSide()) {
            //获取traceID
            String traceId = RpcContext.getContext().getAttachment(TRACE_ID);
            if (StringUtils.isBlank(traceId)) {
                traceId = UUID.randomUUID().toString().replaceAll("-", "");
            }
            //重新设置traceID。因为调用一次RpcContext对象的attachment就会清空。目的是为了多重调用时传递traceID
            MDCUtil.put(MDCUtil.Type.TRACE_ID, traceId);
        }

        Result result = invoker.invoke(invocation);
        long elapsed = System.currentTimeMillis() - start;
        if (invoker.getUrl() != null) {
            try {
                log.info("dubbo log [{}#{}], traceid={}, param={}, [result={}], [Exception={}], [elapsed={}]   ",
                        invoker.getInterface(), invocation.getMethodName(),
                        RpcContext.getContext().getAttachment(TRACE_ID),
                        JSONArray.toJSONString(invocation.getArguments()),
                        JSONObject.toJSONString(result.getValue()),
                        result.getException(),
                        elapsed);
            } catch (Exception e) {
                log.warn(e.getMessage(), e);
            }
        }
        return result;
    }
}
