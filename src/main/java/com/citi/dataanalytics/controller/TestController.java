package com.citi.dataanalytics.controller;

import com.citi.dataanalytics.entity.Stock;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {

    @RequestMapping("/hello")
    public String hello(){
        return "index";
    }

    @RequestMapping("/home")
    public String home(){
        return "home";
    }

    @RequestMapping("/stock")
    @ResponseBody
    public List<Stock> getStocks(){
        ArrayList<Stock> stocks = new ArrayList<>();
        stocks.add(new Stock("20111111", "12:00", 42.54, 43.23, 345.5, 1234.35, 1, 2,3,4,5));
        stocks.add(new Stock("20111112", "12:00", 42.54, 43.23, 345.5, 1234.35, 1, 2,3,4,5));
        return stocks;
    }
}
