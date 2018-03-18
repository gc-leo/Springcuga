package com.example.demo.controllers;

import com.example.demo.domain.Cpoi;
import com.example.demo.services.CpoiService;
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

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
public class CpoiControllerTest {

    @Mock
    private CpoiService cpoiService;

    @InjectMocks
    private CpoiController cpoiController;


    private MockMvc mockMvc;

    private String id;
    private Cpoi cpoi;

    @Before
    public void setUp() throws Exception {

        id = "5aaa67746991b13bae8b9085";
        cpoi = new Cpoi();
        cpoi.setId(id);
        cpoi.setDescription("Simple description");
        cpoi.setImage(null);
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(cpoiController).build();

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAllTest() throws Exception {

//        when(cpoiService.getAll()).thenReturn(new ArrayList<Cpoi>());
//        mockMvc.perform(get("/cpoi")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(0)));
//        verify(cpoiService, times(1)).getAll();

    }

    @Test
    public void getByIdTest() throws Exception {

        when(cpoiService.getById(id)).thenReturn(cpoi);
        mockMvc.perform(get("/cpoi/" + id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.is(cpoi.getId())))
                .andExpect(jsonPath("$.description", Matchers.is(cpoi.getDescription())));
        verify(cpoiService, times(1)).getById(id);

    }

    @Test
    public void addTest() throws Exception {

        mockMvc.perform(post("/cpoi")
                .content(toJson(cpoi))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
        verify(cpoiService, times(1)).add(cpoi);

    }

    @Test
    public void removeTest() throws Exception {

        mockMvc.perform(delete("/cpoi/" + id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
        verify(cpoiService, times(1)).delete(id);

    }

    @Test
    public void update() throws Exception {

        mockMvc.perform(put("/cpoi")
                .content(toJson(cpoi))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(cpoiService, times(1)).update(cpoi);

    }

    private byte[] toJson(Object r) throws Exception {
        ObjectMapper map = new ObjectMapper();
        return map.writeValueAsString(r).getBytes();
    }

}