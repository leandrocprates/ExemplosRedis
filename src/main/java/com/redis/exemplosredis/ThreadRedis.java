/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redis.exemplosredis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

/**
 *
 * @author lprates
 */
public class ThreadRedis implements Runnable{

    JedisPool jedisPool = null ; 
    
    
    public ThreadRedis(JedisPool jedisPool){
        this.jedisPool = jedisPool;
    }
    
    @Override
    public void run() {
        
        try (Jedis jedis = this.jedisPool.getResource()) {
            
            //jedis.watch("teste");
            
            //Transaction t = jedis.multi() ; 
            
            //Response<Long> retorno = t.setnx("teste", "valor");
/*            
            for ( int i=0 ;  i< 1000 ; i++){
                System.out.println(i +"-"+ Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getName());
                t.set("teste", Thread.currentThread().getName());
            }
*/
            //t.exec();
            
            
            
            Long retorno = jedis.setnx("teste", "valor");
            if ( retorno == 1 ){
                jedis.expire("teste", 20);
            }
            
            
            
            System.out.println("Saida: " + retorno ); 
            
        }
        
        
    }
    
}
