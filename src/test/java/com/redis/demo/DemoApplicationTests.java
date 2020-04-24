package com.redis.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {

        Jedis jedis = new Jedis("localhost", 6379, 100000);
        // 打印1秒内对Redis的操作次数
        System.out.println("redis每秒操作：" + jedis.get("key1") + "次");
    }

}
