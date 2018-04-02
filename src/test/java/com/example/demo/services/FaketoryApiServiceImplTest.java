package com.example.demo.services;


import com.example.demo.external_api.faketory_api.domain.User;
import com.example.demo.external_api.faketory_api.services.FaketoryApiService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FaketoryApiServiceImplTest {

//    @Autowired
//    FaketoryApiService faketoryApiService;
//
//    @Before
//    public void setUp() throws Exception {
//    }
//
//
//    @Test
//    public void testGetUsers() throws Exception {
//
//        List<User> users = faketoryApiService.getUsers(3);
//
//        assertEquals(4, users.size());
//    }
}