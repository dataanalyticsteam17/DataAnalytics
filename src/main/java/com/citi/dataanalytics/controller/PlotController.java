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
        System.out.println(valueType); // Open Price,High Price,Low Price,Close Price,Volume
        System.out.println(startDate);
        System.out.println(endDate);
        ArrayList<String> stocks = (ArrayList<String>) session.getAttribute("stockList");
        Map<String,String[][]> stocksData=new HashMap<String,String[][]>();
        for(int i=0;i<stocks.size();i++){
            String stock_symbol=stocks.get(i);
            System.out.println("Stock symbol:"+stock_symbol);
            if(startDate.equals(endDate)){
                //get one day data
                String[][] singleStockData=PlotDataget.getDataofday(valueType,startDate,stock_symbol);
                System.out.println(singleStockData[0][0]+"  "+singleStockData[0][1]);
                stocksData.put(stock_symbol,singleStockData);
            }else{
                //get several days data
                String[][] singleStockData=PlotDataget.getDataoftime(valueType,startDate,endDate,stock_symbol);
                stocksData.put(stock_symbol,singleStockData);
            }
        }
        return stocksData;
    }
}
