package com.example.demo.repositories.cpoi;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class CpoiRepositoryTest {

    @Autowired
    private CpoiRepository cpoiRepository;

    @Before
    public void setUp() throws Exception {
        System.out.println(cpoiRepository);


    }

    @After
    public void tearDown() throws Exception {

    }


}