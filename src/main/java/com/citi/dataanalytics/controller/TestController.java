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

    @RequestMapping("/plot")
    public String plot() {return "plot";}

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

    @RequestMapping("/getStockData")
    @ResponseBody
    public String[][] getStockData(){
        String[][] stockData=new String[][]{{"20120101","14"},{"20120201","17"},{"20120301","19"},{"20120401","20"},
                {"20120501","18"},{"20120601","20"},{"20120701","19"},{"20120801","23"},
                {"20120901","22"},{"20121001","24"},{"20121101","23"},{"20121201","25"}};
//        System.out.println(stockData[0][0]);
        return stockData;
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
    @ResponseBody
    public String selectStock(@RequestParam(value = "stocks[]") ArrayList<String> stocks, HttpSession session) {
        session.setAttribute("stockList", stocks);
        return "home";
    }

}
