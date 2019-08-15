package com.citi.dataanalytics.controller;

import com.citi.dataanalytics.Analysis.AnalysisPlot;
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
    public Map<String,String[][]> getStockData(@RequestParam String valueType, @RequestParam String startDate, @RequestParam String endDate, HttpSession session){
//        System.out.println(valueType); // Open Price,High Price,Low Price,Close Price,Volume
        ArrayList<String> stocks = (ArrayList<String>) session.getAttribute("stockList");
        Map<String,String[][]> stocksData=new HashMap<String,String[][]>();
        for(int i=0;i<stocks.size();i++){
            String stock_symbol=stocks.get(i);
            if(startDate.equals(endDate)){
                //get one day data
                String[][] singleStockData=PlotDataget.getDataofday(valueType,startDate,stock_symbol);
                stocksData.put(stock_symbol,singleStockData);
            }else{
                //get several days data
                String[][] singleStockData=PlotDataget.getDataoftime(valueType,startDate,endDate,stock_symbol);
                stocksData.put(stock_symbol,singleStockData);
            }
        }
        return stocksData;
    }

    @RequestMapping("/getAnalyticsData")
    @ResponseBody
    public Map<String,String[][]> getAnalyticsData(@RequestParam String stockSymbol, @RequestParam String startDate, @RequestParam String endDate){
        Map<String,String[][]> analyticsData=new HashMap<String,String[][]>();
        String[][] priceChangeData=AnalysisPlot.getPriceChange(startDate,endDate,stockSymbol);
        String[][] maxMinChangeData=AnalysisPlot.getMaxMinChange(startDate,endDate,stockSymbol);
        analyticsData.put("Stock Advance-Decline",priceChangeData);
        analyticsData.put("Stock High-Low",maxMinChangeData);
        return analyticsData;
    }
}
