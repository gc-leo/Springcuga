package com.example.demo.services;

import com.example.demo.domain.Coin;
import com.example.demo.external_api.coin_market_cap_api.domain.CoinInfo;
import com.example.demo.external_api.coin_market_cap_api.services.CoinMarketCapApiService;
import com.example.demo.repositories.CoinRepository;
import org.springframework.stereotype.Service;

@Service
public class CoinService extends CrudService<Coin, String, CoinRepository> {

    private CoinMarketCapApiService coinMarketCapApiService;

    public CoinService(CoinRepository repository, CoinMarketCapApiService coinMarketCapApiService) {
        super(repository);
        this.coinMarketCapApiService = coinMarketCapApiService;
    }

    public CoinInfo getCoinMarketCapInfosForCoin(String id){
        Coin coin = getById(id);
        String name = coin.getName();
        return coinMarketCapApiService.getCoinInfo(name);
    }
}
