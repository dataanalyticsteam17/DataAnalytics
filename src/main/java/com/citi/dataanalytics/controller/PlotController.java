package com.citi.dataanalytics.controller;

import com.citi.dataanalytics.classes.PlotDataget;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class PlotController {

    @RequestMapping("/getStockData")
    @ResponseBody
    public Map<String,String[][]> getStockData(@RequestParam String valueType, @RequestParam String startDate, @RequestParam String endDate, HttpSession session) throws IOException,java.text.ParseException{
        System.out.println(valueType);
        System.out.println(startDate);
        System.out.println(endDate);
        String value_name=valueType;  // Open Price,High Price,Low Price,Close Price,Volume
        ArrayList<String> stocks = (ArrayList<String>) session.getAttribute("stockList");
        String day="20160104";
        Map<String,String[][]> stocksData=new HashMap<>();
        for(int i=0;i<stocks.size();i++){
            String stock_symbol=stocks.get(i);//Stock name
            System.out.println("Stock symbol:"+stock_symbol);
            if(startDate.equals(endDate)){
                //get one day   getDataofday(String value_name, String day,String symbol)
                String[][] singleStockData=PlotDataget.getDataofday(value_name,startDate,stock_symbol);
                System.out.println(singleStockData[0][0]+"  "+singleStockData[0][1]);
                stocksData.put(stock_symbol,singleStockData);
            }else{
                //get several days
                String[][] singleStockData=PlotDataget.getDataoftime(value_name,startDate,endDate,stock_symbol);
                System.out.println(singleStockData[0][0]+"  "+singleStockData[0][1]);
                // Rory - should use logging not println
                stocksData.put(stock_symbol,singleStockData);
            }
        }
        return stocksData;
    }
}
