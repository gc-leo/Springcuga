package com.example.demo.services;

import com.example.demo.domain.Exchange;
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

    public ExchangeService(ExchangeRepository repository, CryptoExchangeApiService cryptoExchangeApiService){
        super(repository);
        this.cryptoExchangeApiService =  cryptoExchangeApiService;
    }


//TODO: implemet if they give you list of other curencies
//public Exchange getExchangeCurrency(String baseCurency, List<String> currencyList)

    public Exchange getExchangeCurrency(String baseCurency){

        List<String> currencyList = new ArrayList<>();
        currencyList.add("BTC");
        currencyList.add("ETH");
        currencyList.add("USD");
        currencyList.add("EUR");
        currencyList.add("RSD");

        CryptoCurrencyPrice cryptoCurrencyPrice = cryptoExchangeApiService.getCryptoCurrencyPriceByValute(baseCurency,currencyList);

        Exchange ex = new Exchange();
        ex.setBtc(cryptoCurrencyPrice.getBTC()*1.1);
        ex.setEth(cryptoCurrencyPrice.getETH()*1.1);
        ex.setRsd(cryptoCurrencyPrice.getRSD()*1.1);
        ex.setUsd(cryptoCurrencyPrice.getUSD()*1.1);
        ex.setEur(cryptoCurrencyPrice.getEUR()*1.1);
        return ex;
    }

}
