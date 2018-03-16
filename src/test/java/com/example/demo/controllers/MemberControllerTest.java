package com.example.demo.controllers;

import com.example.demo.domain.Member;
import com.example.demo.domain.Location;
import com.example.demo.services.MemberService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
public class MemberControllerTest {

    @Mock
    private MemberService memberService;

    @InjectMocks
    private MemberController memberController;


    private MockMvc mockMvc;

    private String id;
    private Member member;

    @Before
    public void setUp() throws Exception {

        id = "5aaa67746991b13bae8b9085";
        member = new Member();
        member.setId(id);
        member.setName("Pera");
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(memberController).build();

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAllTest() throws Exception {

        when(memberService.getAll()).thenReturn(new ArrayList<Member>());
        mockMvc.perform(get("/member")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
        verify(memberService, times(1)).getAll();

    }

    @Test
    public void getByIdTest() throws Exception {

        when(memberService.getById(id)).thenReturn(member);
        mockMvc.perform(get("/member/" + id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.is(member.getId())))
                .andExpect(jsonPath("$.name", Matchers.is(member.getName())));
        verify(memberService, times(1)).getById(id);

    }

    @Test
    public void addTest() throws Exception {

        mockMvc.perform(post("/member")
                .content(toJson(member))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
        verify(memberService, times(1)).add(member);

    }

    @Test
    public void removeTest() throws Exception {

        mockMvc.perform(delete("/member/" + id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
        verify(memberService, times(1)).delete(id);

    }

    @Test
    public void update() throws Exception {

        mockMvc.perform(put("/member")
                .content(toJson(member))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(memberService, times(1)).update(member);

    }

    private byte[] toJson(Object r) throws Exception {
        ObjectMapper map = new ObjectMapper();
        return map.writeValueAsString(r).getBytes();
    }

}