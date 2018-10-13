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

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMongodbDockerApplicationTests {

    @Autowired
    private UserRepository userRepository;

    private static Logger logger = LoggerFactory.getLogger(SpringbootMongodbDockerApplicationTests.class);


    @Before
    public void setup() {
        userRepository.deleteAll();

        User user1 = new User("1", "minmin", "loveminmin1", "test1@example.com");
        User user2 = new User("2", "xiaominmin", "loveminmin2", "test2@example.com");

        userRepository.save(Arrays.asList(user1, user2));
    }


    @Test
    public void findAll() {
        List<User> users = userRepository.findAll();

        users.forEach((user) ->
                logger.info(user.getId(), user.getUsername(), user.getPassword(), user.getEmail()) );
    }


    @Test
    public void contextLoads() {
    }

}
