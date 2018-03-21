package com.example.demo.controllers;

import com.example.demo.domain.Coin;
import com.example.demo.external_api.coin_market_cap_api.domain.CoinInfo;
import com.example.demo.services.CoinService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/coin")
@Api(description = "coin api")
public class CoinController {

    private CoinService coinService;

    public CoinController(CoinService coinService) {
        this.coinService = coinService;
    }

    @ApiOperation(value = "Get list of all Coins", notes = "Some notes")
    @GetMapping
    public ResponseEntity<Page<Coin>> getAll(Pageable pageable) {
        return new ResponseEntity<>(coinService.getAll(pageable), HttpStatus.OK);
    }

    @ApiOperation(value = "Get single Coin by id", notes = "Some notes")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Coin> getById(@PathVariable String id) {
        return new ResponseEntity<>(coinService.getById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Create coin", notes = "Some notes")
    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody Coin cPoi) {
        coinService.add(cPoi);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Delete coin", notes = "Some notes")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        coinService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Update coin", notes = "Some notes")
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Coin cPoi) {
        coinService.update(cPoi);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    //This route should be protected hnjo-hnjo
//    //If mybe admin wana change by hand value of the certain coin?
//
//    @ApiOperation(value = "Update Dolar Value of Coin", notes = "Update Dolar Value of Coin")
//    @PutMapping
//    public ResponseEntity<?> update(@RequestBody Double value) {
//        coinService.setCurrenciesDollarValue(Coin);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @ApiOperation(value="Get Coin Market Cap Details for coin", notes = "Some notes")
    @GetMapping(value = "coinmarketcap/{id}")
    public ResponseEntity<CoinInfo> getCoinMarketCapInfoForCoin(@PathVariable String id){
        return new ResponseEntity<>(coinService.getCoinMarketCapInfosForCoin(id), HttpStatus.OK);
    }
}
