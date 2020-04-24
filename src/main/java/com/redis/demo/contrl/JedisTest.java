package com.redis.demo.contrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@RestController
@RequestMapping(value = "/redis")
public class JedisTest {

    @Autowired
    JedisPool redisPoolFactory;

    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping(value = "/test")
    public void test(){
        System.out.println("1"+redisTemplate.opsForValue().get("key1"));
        try (Jedis jedis = redisPoolFactory.getResource()) {
            jedis.get("key1");
            System.out.println(jedis.get("key1"));
        }

    }

}
