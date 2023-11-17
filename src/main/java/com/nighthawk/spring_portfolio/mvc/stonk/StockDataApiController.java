package com.nighthawk.spring_portfolio.mvc.stonk;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping(path = "/api")
public class StockDataApiController {

    @GetMapping("/stockdata")
    public ResponseEntity<String> getStockData(@RequestParam(name = "symbol") String symbol) {
        try {
            // Build the API request URL with the provided symbol
            String apiUrl = "https://alpha-vantage.p.rapidapi.com/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol=" + symbol + "&outputsize=compact&datatype=json";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .header("X-RapidAPI-Key", "53ed50b3c5mshb1ebce663573fbap1a08a4jsneab1f395e0a6")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            return new ResponseEntity<>(response.body(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error fetching stock data: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/stocksearch")
    public ResponseEntity<String> getStocks(@RequestParam(name = "symbol") String symbol) {
        try {
            // Build the API request URL with the provided symbol
            String apiUrl = "https://quotient.p.rapidapi.com/search/symbol?query=" + symbol + "&categories=EQT%2CETF&regions=US%2CUK%2CEU";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .header("X-RapidAPI-Key", "53ed50b3c5mshb1ebce663573fbap1a08a4jsneab1f395e0a6")
                    .header("X-RapidAPI-Host", "quotient.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            return new ResponseEntity<>(response.body(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error fetching stock data: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}