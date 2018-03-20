package com.example.demo.controllers;

import com.example.demo.domain.Exchange;
import com.example.demo.services.ExchangeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

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

    private boolean isValidCurrency(String currency){
        try {
            supportedCurencies c = supportedCurencies.valueOf(currency);
            return true;
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
            return false;
        }

    }

    @ApiOperation(value = "Get list of Converted currencies for base currency input", notes = "Some notes")
    @GetMapping(value = "/{currency}")
    public ResponseEntity<Exchange> getByCurrency(@PathVariable String currency) {

        if(!isValidCurrency(currency))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>(exchangeService.getExchangeCurrency(currency), HttpStatus.OK);

    }

}
