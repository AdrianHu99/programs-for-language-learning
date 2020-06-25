package com.qi.redisdemo.controller;

import com.qi.redisdemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class StudentHandler {

    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/set")
    public void set(@RequestBody Student student) {
        redisTemplate.opsForValue().set("Student", student);
    }

    @GetMapping("/get/{key}")
    public Student get(@PathVariable("key") String key) {
        return (Student) redisTemplate.opsForValue().get(key);
    }

    @DeleteMapping("/delete/{key}")
    public boolean delete(@PathVariable("key") String key) {
        redisTemplate.delete(key);
        return redisTemplate.hasKey(key);
    }

    @GetMapping("/string")
    public String stringTest() {
        redisTemplate.opsForValue().set("str", "Hello World");
        String str = (String) redisTemplate.opsForValue().get("str");
        return str;
    }

    @GetMapping("/list")
    public List<String> listTest() {
        ListOperations<String, String> listOperations = redisTemplate.opsForList();
        listOperations.leftPush("list", "Hello");
        listOperations.leftPush("list", "World");
        listOperations.leftPush("list", "Java");
        listOperations.leftPush("list", "Please");
        listOperations.leftPush("list", "Open");
        listOperations.leftPush("list", "The");
        listOperations.leftPush("list", "Door");
        List<String> list = listOperations.range("list", 0,3);
        return list;
    }

    @GetMapping("/set")
    public Set<String> setTest() {
        SetOperations<String, String> setOperations = redisTemplate.opsForSet();
        setOperations.add("set", "Hello");
        setOperations.add("set", "Hello");
        setOperations.add("set", "World");
        setOperations.add("set", "World");
        setOperations.add("set", "Java");
        setOperations.add("set", "Java");

        Set<String> set = setOperations.members("set");
        return set;
    }

    @GetMapping("/hash")
    public void hashTest() {
        // key -> <hashkey, value>
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        hashOperations.put("key", "hashKey", "value");
        System.out.println(hashOperations.get("key", "hashKey"));
    }
}
