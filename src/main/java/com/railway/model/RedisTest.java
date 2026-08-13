package com.railway.model;

import com.railway.util.RedisUtil;
import redis.clients.jedis.Jedis;

public class RedisTest {

    public static void main(String[] args) {

        Jedis jedis = RedisUtil.getConnection();

        jedis.set("test", "Redis Working");

        System.out.println(jedis.get("test"));

        jedis.close();
    }
}