package com.example.springboot;

import com.example.springboot.models.User;
import com.example.springboot.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMongodbDockerApplicationTests {

    @Autowired
    private UserRepository userRepository;

    private static Logger logger = LoggerFactory.getLogger(SpringbootMongodbDockerApplicationTests.class);


    @Test
    public void contextLoads() {
    }

}
