package com.dail.util;

import com.dail.constant.RedisConstant;
import com.dail.dto.CacheResult;
import com.dail.utils.SerializeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;

/**
 * @Auther: dailiang
 * @Date: 2018/12/26 14:36
 * @Description:
 */
@Component
@Slf4j
public class RedisClient {

    @Autowired
    private JedisPool jedisPool;


    /**
     * 获得缓存
     * @param key
     * @return
     */
    public CacheResult get(String key) {
        CacheResult result = new CacheResult();
        result.setData(SerializeUtil.unserialize(this.getBase(key)));
        return result;
    }

    /**
     * 设置缓存，默认超时时间
     * @param key
     * @param value
     * @return
     */
    public String set(String key, Object value) {
        return this.setBase(key, SerializeUtil.serialize(value), RedisConstant.redisToExpireDefault);
    }

    /**
     *
     * @param key
     * @param value
     * @param secondsToExpire 单位秒
     * @return
     */
    public String set(String key, Object value, int secondsToExpire) {
        return this.setBase(key, SerializeUtil.serialize(value), secondsToExpire);
    }

    /**
     *
     * @param key
     * @param value
     * @param millisecondsToExpire 单位毫秒
     * @return
     */
    public String set(String key, Object value, long millisecondsToExpire) {
        return this.setBase(key, SerializeUtil.serialize(value), millisecondsToExpire);
    }

    /**
     * 删除缓存
     * @param key
     * @return
     */
    public String delete(String key) {
        Jedis jedis = null;
        String str = "";
        try {
            jedis = jedisPool.getResource();
            jedis.del(key);
        } finally {
            try {
                jedis.close();
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
        return str;
    }


    /**
     * 设置缓存
     * @param key
     * @param value
     * @param secondsToExpire 单位秒
     * @return
     */
    private String setBase(String key, String value, int secondsToExpire) {
        Jedis jedis = null;
        String str = "";
        try {
            jedis = jedisPool.getResource();
            SetParams setParams = new SetParams();
            // 单位秒
            setParams.ex(secondsToExpire);
            str = jedis.set(key, value, setParams);
        } finally {
            try {
                jedis.close();
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
        return str;
    }

    /**
     * 设置缓存
     * @param key
     * @param value
     * @param millisecondsToExpire 单位毫秒
     * @return
     */
    private String setBase(String key, String value, long millisecondsToExpire) {
        Jedis jedis = null;
        String str = "";
        try {
            jedis = jedisPool.getResource();
            SetParams setParams = new SetParams();
            // 单位毫秒
            setParams.px(millisecondsToExpire);
            str = jedis.set(key, value, setParams);
        } finally {
            try {
                jedis.close();
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
        return str;
    }

    /**
     * 获取缓存
     * @param key
     * @return
     */
    private String getBase(String key) {
        Jedis jedis = null;
        String str = "";
        try {
            jedis = jedisPool.getResource();
            str = jedis.get(key);
        } finally {
            try {
                jedis.close();
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
        return str;
    }

}
