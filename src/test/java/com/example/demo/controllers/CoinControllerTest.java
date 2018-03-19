package com.example.demo.controllers;

import com.example.demo.domain.Coin;
import com.example.demo.services.CoinService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Locale;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@EnableSpringDataWebSupport
@WebAppConfiguration
public class CoinControllerTest {

    @Mock
    private CoinService coinService;

    @InjectMocks
    private CoinController coinController;


    private MockMvc mockMvc;

    private String id;
    private Coin coin;

    @Before
    public void setUp() throws Exception {

        id = "5aaa67746991b13bae8b9085";
        coin = new Coin(id, "Bitcoin", "BTC");
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(coinController).setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers(new ViewResolver() {
                    @Override
                    public View resolveViewName(String viewName, Locale locale) throws Exception {
                        return new MappingJackson2JsonView();
                    }
                }).build();

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAllTest() throws Exception {

        mockMvc.perform(get("/coin?page=0&size=20")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void getByIdTest() throws Exception {

        when(coinService.getById(id)).thenReturn(coin);
        mockMvc.perform(get("/coin/" + id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.is(coin.getId())))
                .andExpect(jsonPath("$.name", Matchers.is(coin.getName())))
                .andExpect(jsonPath("$.criptoname", Matchers.is(coin.getCriptoname())));
        verify(coinService, times(1)).getById(id);

    }

    @Test
    public void addTest() throws Exception {

        mockMvc.perform(post("/coin")
                .content(toJson(coin))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
        verify(coinService, times(1)).add(coin);

    }

    @Test
    public void removeTest() throws Exception {

        mockMvc.perform(delete("/coin/" + id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
        verify(coinService, times(1)).delete(id);

    }

    @Test
    public void update() throws Exception {

        mockMvc.perform(put("/coin")
                .content(toJson(coin))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(coinService, times(1)).update(coin);

    }

    private byte[] toJson(Object r) throws Exception {
        ObjectMapper map = new ObjectMapper();
        return map.writeValueAsString(r).getBytes();
    }

}