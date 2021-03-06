package com.ljl.mall.tiny.service;

/**
 *  redis操作serviec
 */

public interface RedisService {
    /**
     * 存储数据
     */
    void set(String key,String value);

    /**
     * 获取数据
     */
    String get(String key);

    /**
     * 设置超时时间
     */
    boolean expire(String key,long expire);

    /**
     * 删除数据
     */
    void remove(String key);

    /**
     * 自动增加
     */
    Long increment(String key,long dalta);
}
