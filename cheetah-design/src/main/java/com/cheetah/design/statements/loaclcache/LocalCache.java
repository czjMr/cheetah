package com.cheetah.design.statements.loaclcache;

import com.cheetah.design.statements.constant.LocalCacheKey;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Slf4j
public class LocalCache {

    /**
     * 缓存一天
     */
    private static final int REPORT_CACHE_DAY = 1;

    /***
     * 用于缓存学校
     */
    private LoadingCache<String, Map<String,String>> reportCache = CacheBuilder.newBuilder()
            // 缓存刷新时间
            .refreshAfterWrite(REPORT_CACHE_DAY, TimeUnit.DAYS)
            // 设置缓存个数
            .maximumSize(20)
            .build(new CacheLoader<String, Map<String,String>>() {
                @Override
                public Map<String,String> load(String key) {
                    // 缓存不存在返回空对象
                    return Maps.newHashMap();
                }

            });


    public Map<String,String> getSchool() {
        try {
            return reportCache.get(LocalCacheKey.SCHOOL);
        } catch (ExecutionException e) {
            log.error("获取本地缓存学校数据异常",e);
            return Maps.newHashMap();
        }
    }


    public Map<String,String> getSubject() {
        try {
            return reportCache.get(LocalCacheKey.SUBJECT);
        } catch (ExecutionException e) {
            log.error("获取本地缓存学科数据异常",e);
            return Maps.newHashMap();
        }
    }


    public Map<String,String> initSchool() {
        // TODO 查询数据库
        Map<String,String> school = Maps.newHashMap();
        reportCache.put(LocalCacheKey.SCHOOL,school);
        return school;
    }


    public Map<String,String> initSubject() {
        // TODO 查询数据库
        Map<String,String> subject = Maps.newHashMap();
        reportCache.put(LocalCacheKey.SUBJECT,subject);
        return subject;
    }

}
