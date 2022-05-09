package com.youku.atm.easycast;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisTest {
	
	public static void main(String[] args) {
		
//		Jedis jedis = new Jedis("11.239.171.222", 6379);
//	    jedis.set("singleJedis", "hello jedis!");
//	    System.out.println(jedis.get("singleJedis"));
//	    jedis.close();
		
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
	    jedisPoolConfig.setMaxTotal(10);
	    JedisPool pool = new JedisPool(jedisPoolConfig, "localhost", 6379, 0, null);

	    Jedis jedis = null;
	    try{
	        jedis = pool.getResource();
	        jedis.set("pooledJedis", "hello jedis pool!");
	        System.out.println(jedis.get("pooledJedis"));
	    }catch(Exception e){
	        e.printStackTrace();
	    }finally {
	        //还回pool中
	        if(jedis != null){
	            jedis.close();
	        }
	    }
	    pool.close();

	}

}
