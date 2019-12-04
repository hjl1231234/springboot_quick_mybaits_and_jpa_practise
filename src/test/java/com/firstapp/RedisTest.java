package com.firstapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.firstapp.domain.UserJPA;
import com.firstapp.mapper.UserMapper;
import com.firstapp.repository.UserJPARepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MySpringBootApp.class)
public class RedisTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private UserJPARepository userJPARepository;

    @Test
    public void test1() throws JsonProcessingException {
        //1 从Redis中获得数据，json格式
        String userListJson = redisTemplate.boundValueOps("userJPA.findAll").get();

        //2 判断是否有数据
        if (null == userListJson) {
            //3 不存在去数据库查询
            List<UserJPA> lists = userJPARepository.findAll();
            //4 数据在控制台打印
//            将List变为json
            ObjectMapper objectMapper = new ObjectMapper();
            userListJson = objectMapper.writeValueAsString(lists);
            redisTemplate.boundValueOps("userJPA.findAll").set(userListJson);
            System.out.println("======================从DB中查询");

        } else
            System.out.println("======================从redis中查询");
        System.out.println(userListJson);
    }
//    @Test
    public void test(){
        Jedis jedis=new Jedis("192.168.199.129",6379);
        jedis.set("username","aaa");
        jedis.close();

    }
}
