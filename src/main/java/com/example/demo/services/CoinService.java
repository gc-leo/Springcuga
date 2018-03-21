package com.example.demo.services;

import com.example.demo.domain.Coin;
import com.example.demo.domain.Exchange;
import com.example.demo.external_api.coin_market_cap_api.domain.CoinInfo;
import com.example.demo.external_api.coin_market_cap_api.services.CoinMarketCapApiService;
import com.example.demo.external_api.criptocompare_api.domain.CryptoCurrencyPrice;
import com.example.demo.external_api.criptocompare_api.services.CryptoExchangeApiService;
import com.example.demo.repositories.CoinRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoinService extends CrudService<Coin, String, CoinRepository> {

    private CoinMarketCapApiService coinMarketCapApiService;

    private CryptoExchangeApiService cryptoExchangeApiService;

    public CoinService(CoinRepository repository, CoinMarketCapApiService coinMarketCapApiService, CryptoExchangeApiService cryptoExchangeApiService) {
        super(repository);
        this.coinMarketCapApiService = coinMarketCapApiService;
        this.cryptoExchangeApiService = cryptoExchangeApiService;
    }

    public CoinInfo getCoinMarketCapInfosForCoin(String id){
        Coin coin = getById(id);
        String name = coin.getName();
        return coinMarketCapApiService.getCoinInfo(name);
    }


    private double setOurPrice(double realCoinPrice){
        //could save in config...but for now let it sit here
        double ourPriceMultiplier = 1.1;
        return realCoinPrice * ourPriceMultiplier;
    }

    //@TODO:leo Implement setter  that will set BTC, ETH, USD, EUR, RSD for Coin from cryptocompare-api
    /**
     * Sets Coin.setDollarValue() from cryptocompare-api in Coin for popular currencies
     * BTC, ETH, USD, EUR, RSD
     */
    public void setCurrenciesDollarValue(){

        CryptoCurrencyPrice basecryptoCurrencysPrices = cryptoExchangeApiService.getCryptoCurrencyPriceByValute("USD");

        List<Coin> allCoins = getRepository().findAll();

        for(Coin coin: allCoins){
            // This switch is so ugly
            // maybe implement interface and use pattern to declare for each what it should do
            // but then i need better Currency structure for starters
            switch (coin.getCriptoname()){
                case "BTC":
                    coin.setDollarValue( setOurPrice(basecryptoCurrencysPrices.getBTC()) ); break;
                case "ETH":
                    coin.setDollarValue( setOurPrice(basecryptoCurrencysPrices.getETH()) ); break;
                case "EUR":
                    coin.setDollarValue( setOurPrice(basecryptoCurrencysPrices.getEUR()) ); break;
                case "USD":
                    coin.setDollarValue( setOurPrice(basecryptoCurrencysPrices.getUSD()) ); break;
                case "RSD":
                    coin.setDollarValue( setOurPrice(basecryptoCurrencysPrices.getRSD()) ); break;
                default:
                    coin.setDollarValue(0); break;
            }
           getRepository().save(coin);
        }

    }
}
