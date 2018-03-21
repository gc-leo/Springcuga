package com.example.demo.services;

import com.example.demo.domain.Coin;
import com.example.demo.domain.Exchange;
import com.example.demo.domain.ExchangeRates;
import com.example.demo.external_api.criptocompare_api.domain.CryptoCurrencyPrice;
import com.example.demo.external_api.criptocompare_api.services.CryptoExchangeApiService;
import com.example.demo.repositories.ExchangeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class ExchangeService extends CrudService<Exchange, String, ExchangeRepository> {

    public CryptoExchangeApiService cryptoExchangeApiService;

    public CoinService coinService;

    public ExchangeService(ExchangeRepository repository, CryptoExchangeApiService cryptoExchangeApiService, CoinService coinService){
        super(repository);
        this.cryptoExchangeApiService =  cryptoExchangeApiService;
        this.coinService = coinService;
    }

//TODO: implemet if they give you list of other curencies
//public Exchange getExchangeRates(String baseCurency, List<String> currencyList)

    public Exchange getExchangeRates(String baseCurency){

        List<String> currencyList = new ArrayList<>();
        currencyList.add("BTC");
        currencyList.add("ETH");
        currencyList.add("USD");
        currencyList.add("EUR");
        currencyList.add("RSD");

        //call cryptoExchangeApiService
        CryptoCurrencyPrice cryptoCurrencyPrice = cryptoExchangeApiService.getCryptoCurrencyPriceByValute(baseCurency,currencyList);

        Coin coin = coinService.getRepository().findCoinByCriptoname(baseCurency);

        Exchange ex = new Exchange();
        ex.setBaseCurrency(coin);

        ExchangeRates exchangeRates = new ExchangeRates();
        exchangeRates.setBtc( cryptoCurrencyPrice.getBTC() );
        exchangeRates.setEth( cryptoCurrencyPrice.getETH() );
        exchangeRates.setRsd( cryptoCurrencyPrice.getRSD() );
        exchangeRates.setUsd( cryptoCurrencyPrice.getUSD() );
        exchangeRates.setEur( cryptoCurrencyPrice.getEUR() );

        return ex;
    }

}
