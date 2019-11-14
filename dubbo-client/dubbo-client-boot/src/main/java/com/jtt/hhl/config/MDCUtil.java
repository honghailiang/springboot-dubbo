package com.jtt.hhl.config;

import org.slf4j.MDC;

/**
 * @Description: MDC（Mapped Diagnostic Context，映射调试上下文）是 log4j 和 logback 提供的一种方便在多线程条件下记录日志的功能。
 * 　MDC 可以看成是一个与当前线程绑定的哈希表，可以往其中添加键值对。MDC 中包含的内容可以被同一线程中执行的代码所访问。当前线程的子线程会继承其父线程中的 MDC 的内容。
 * 当需要记录日志时，只需要从 MDC 中获取所需的信息即可。MDC 的内容则由程序在适当的时候保存进去。对于一个 Web 应用来说，通常是在请求被处理的最开始保存这些数据。
 * @Author: Herman
 * @CreateDate: 2019/11/14 16:01
 */
public class MDCUtil {
    public static void put(Type type,String value) {
        MDC.put(type.name(),value);
    }
    public static String get(Type type) {
        return MDC.get(type.name());
    }
    public static void remove(Type type) {
        MDC.remove(type.name());
    }
    public static void clear() {
        MDC.clear();
    }
    public enum Type {
        TRACE_ID("traceid");
        private String desc;

        Type(String desc) {
            this.desc = desc;
        }
        public String getDesc() {
            return desc;
        }
    }
}
