package com.example.demo.controllers;

import com.example.demo.domain.Exchange;
import com.example.demo.external_api.criptocompare_api.domain.CryptoCurrencyPrice;
import com.example.demo.external_api.criptocompare_api.services.CryptoExchangeApiService;
import com.example.demo.services.ExchangeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Example
 *
 * ExchangeController
 *
 * getByCurrency -> uses our ExchangeService to process data
 * getByCurrencyAndExchange -> uses foregin  cryptoExchangeApiService to process data
 *
 */
@RestController
@RequestMapping("/exchange")
@Api(description = "exchange api")
public class ExchangeController {

    private ExchangeService exchangeService;

    public ExchangeController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    public enum supportedCurencies{
        BTC,ETH,USD,EUR,RSD;
    }

    //quick fix - there must be better way to check if something is inside enum then catching exceptions!
    //validate if currency is one of supportedCurencies
    private boolean isValidCurrency(String currency){
        try {
            supportedCurencies c = supportedCurencies.valueOf(currency);
            return true;
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
            return false;
        }

    }

    @ApiOperation(value = "Get list of Converted currencies for base currency input", notes = "Enter one of suppored curencies(BTC,ETH,USD,EUR,RSD) and see out exchange rates")
    @GetMapping(value = "/{currency}")
    public ResponseEntity<Exchange> getByCurrency(@PathVariable String currency) {

        if(!isValidCurrency(currency))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>(exchangeService.getExchangeRates(currency), HttpStatus.OK);

    }


//    @ApiOperation(value = "Get list of Converted currencies for base currency input", notes = "Enter one of suppored curencies(BTC,ETH,USD,EUR,RSD) and see out exchange rates")
//    @GetMapping(value = "/{currency}/{exchanges}")
//    public ResponseEntity<CryptoCurrencyPrice> getByCurrencyAndExchange(@PathVariable String currency , @PathVariable String[] exchanges) {
//
//        if(!isValidCurrency(currency))
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        else
//            return null;
////            return new ResponseEntity<>(cryptoExchangeApiService.getCryptoCurrencyPriceByValute(currency), HttpStatus.OK);
//
//    }

}
