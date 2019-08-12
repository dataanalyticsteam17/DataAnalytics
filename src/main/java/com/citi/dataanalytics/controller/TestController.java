package com.citi.dataanalytics.controller;

import com.citi.dataanalytics.classes.GetStockName;
import com.citi.dataanalytics.classes.Readdata;
import com.citi.dataanalytics.classes.Record;
import org.apache.commons.logging.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {

    private static final Logger logger= LogManager.getLogger(TestController.class);

    @RequestMapping("/hi")
    public String hello(){
        return "Hello World";
    }

    @RequestMapping("/home")
    public String home(){
        return "home";
    }

    @RequestMapping("/select")
    public String select() {return "select";}

    @RequestMapping("/stock")
    @ResponseBody
    public  ArrayList<Record> getStocks(@RequestParam String start, @RequestParam String end, HttpSession session) {
        ArrayList<String> stocks = (ArrayList<String>) session.getAttribute("stockList");
        ArrayList<Record> records = new ArrayList<>();
        for(String stock:stocks){
            ArrayList<Record> tmpRecord = Readdata. acessDate(start,end,stock);
            for(Record record:tmpRecord){
                records.add(record);
            }
        }
        return records;
    }

    @RequestMapping("/getAllStockName")
    @ResponseBody
    public List<String> getAllStockName() {

        ArrayList<String> stocks;
        try {
            stocks = GetStockName.getstock();
            return stocks;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/selectStock")
    public String selectStock(@RequestParam(value = "stocks[]") ArrayList<String> stocks, HttpSession session) {
        session.setAttribute("stockList", stocks);
        return "home";
    }

}
