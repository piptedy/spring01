package com.atguigu.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;

public class JedisTest {
    @Test
    public void test01(){
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("192.168.6.100",6379);
        //查看服务是否运行，打出pong表示OK
        System.out.println("connection is OK==========>: "+jedis.ping());

    }
    @Test
    public void testString(){
        Jedis jedis = new Jedis("192.168.6.100", 6379);
//        jedis.set("k1","v1");
//        System.out.println(jedis.get("k1"));
        jedis.select(2);
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);

    }
}
