package com.example.demo.services;

import com.example.demo.external_api.coin_market_cap_api.domain.CoinInfo;
import com.example.demo.external_api.coin_market_cap_api.services.CoinMarketCapApiService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoinMarketCapApiServiceTest {

//    @Autowired
//    CoinMarketCapApiService coinMarketCapApiService;
//
//    @Test
//    public void testGetCoinInfo() throws Exception {
//
//        CoinInfo coinInfos = coinMarketCapApiService.getCoinInfo("bitcoin");
//
//        assertEquals("1", coinInfos.getInfos());
//    }
}
