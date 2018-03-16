package com.example.demo.controllers;

import com.example.demo.domain.Admin;
import com.example.demo.services.AdminService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
public class AdminControllerTest {

    @Mock
    private AdminService adminService;

    @InjectMocks
    private AdminController adminController;


    private MockMvc mockMvc;

    private String id;
    private Admin admin;

    @Before
    public void setUp() throws Exception {

        //Create excepted entity
        id = "5aaa67746991b13bae8b9085";
        admin = new Admin();
        admin.setEmail("pera@gmail.com");
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAllTest() throws Exception {

        when(adminService.getAll()).thenReturn(new ArrayList<Admin>());
        mockMvc.perform(get("/admin")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
        verify(adminService, times(1)).getAll();

    }

    @Test
    public void getByIdTest() throws Exception {

        when(adminService.getById(id)).thenReturn(admin);
        mockMvc.perform(get("/admin/" + id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.is(admin.getId())))
                .andExpect(jsonPath("$.email", Matchers.is(admin.getEmail())));
        verify(adminService, times(1)).getById(id);

    }

    @Test
    public void addTest() throws Exception {

        mockMvc.perform(post("/admin")
                .content(toJson(admin))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
        verify(adminService, times(1)).add(admin);

    }

    @Test
    public void removeTest() throws Exception {

        mockMvc.perform(delete("/admin/" + id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
        verify(adminService, times(1)).delete(id);

    }

    @Test
    public void update() throws Exception {

        mockMvc.perform(put("/admin")
                .content(toJson(admin))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(adminService, times(1)).update(admin);

    }

    private byte[] toJson(Object r) throws Exception {
        ObjectMapper map = new ObjectMapper();
        return map.writeValueAsString(r).getBytes();
    }

}