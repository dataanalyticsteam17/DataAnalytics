package com.citi.dataanalytics.controller;

import com.citi.dataanalytics.classes.Readdata;
import com.citi.dataanalytics.classes.Record;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class TestController {

    @RequestMapping("/hi")
    public String hello(){
        return "Hello World";
    }

    @RequestMapping("/home")
    public String home(){
        return "home";
    }

    @RequestMapping("/stock")
    @ResponseBody
    public  ArrayList<Record> getStocks() {
        String sy ="a", start= "20160104",end ="20160106";
        ArrayList<Record> stocks = new ArrayList<Record>();
        System.out.println(Readdata. acessDate(start,end,sy).toString());
        return Readdata. acessDate(start,end,sy);
    }
}
