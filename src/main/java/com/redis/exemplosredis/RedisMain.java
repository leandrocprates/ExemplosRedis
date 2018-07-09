/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redis.exemplosredis;

import com.google.gson.Gson;
import com.redis.model.Registro;
import java.util.List;
import java.util.Set;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 *
 * @author lprates
 */
public class RedisMain {
    
    
    public static void main(String[] args) { 
        //Connecting to Redis server on localhost 
        Jedis jedis = new Jedis("localhost"); 
        System.out.println("Connection to server sucessfully"); 
        System.out.println("Server is running: "+jedis.ping()); 
        
        jedis.del("teste");
        
        /*
        jedis.set("teste", "outro valor");
        jedis.set("teste2", "outro valor teste2 ");
        
        Registro reg = new Registro();
        reg.setId(1);
        reg.setNome("Ze Roberto");

        Gson gson = new Gson();
        jedis.set("objeto", gson.toJson(reg) );
        System.out.println(jedis.get("objeto"));
        
        
        reg = null ; 
        String retorno = jedis.get("objeto");
        reg = gson.fromJson(retorno, Registro.class);
        
        
        System.out.println("Id: " +reg.getId());
        System.out.println("Nome: "+ reg.getNome());
        */
        
        new Thread(new ThreadRedis(PoolRedis.getJedisPool()) , "Thread-1").start();
        new Thread(new ThreadRedis(PoolRedis.getJedisPool()) , "Thread-2").start();
        new Thread(new ThreadRedis(PoolRedis.getJedisPool()) , "Thread-3").start();
        
    }     
    
    
}
