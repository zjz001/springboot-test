package com.example.test;

import com.example.test.annotation.DoSomething;
import com.example.test.domian.User;
import com.example.test.es.EsRepository;
import com.example.test.mapper.UserMapper;
import org.apache.commons.io.FileUtils;
import org.assertj.core.util.Lists;
import org.elasticsearch.repositories.Repository;
import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationTests {

    @Resource
    private UserMapper userMapper;
    @Resource
    private EsRepository repository;

    @Test
    public void testSelect() {
       List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void readJson() throws Exception {
        File filePath = new File("C:/Users/ZZZZ/Desktop/dot20181019_10.json");
        //读取文件
        String input = FileUtils.readFileToString(filePath, "UTF-8");
        //将读取的数据转换为JSONObject
        JSONObject jsonObject = new JSONObject(input);
        JSONArray jsonArray = new JSONArray().put(jsonObject);
        for (int i=0; i<jsonArray.length();i++){

        }
        System.err.println(jsonArray);
    }

   // @Test
    //@DoSomething(name="#name", age="18", sex = "女")
    public void dosome(String name){
        System.out.println();
    }

}
