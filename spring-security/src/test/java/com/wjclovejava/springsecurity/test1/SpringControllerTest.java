package com.wjclovejava.springsecurity.test1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;



/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2019/1/18 16:01
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment =SpringBootTest.WebEnvironment.RANDOM_PORT )
public class SpringControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;


    @Before
    public void before(){
        System.out.println("START TEST");
    }

    @After
    public void after(){
        System.out.println("END TEST");
    }

    @Test
    public void whenQuerySeccuss() throws Exception {
        String abc = testRestTemplate.getForObject("http://127.0.0.1:" + port + "/user", String.class);
        System.out.println(abc);
    }
}
