package com.citi.dataanalytics.controller;

import com.citi.dataanalytics.Analysis.Analysis;
import com.citi.dataanalytics.Analysis.AnalysisOperation;
import com.citi.dataanalytics.Analysis.Element;
import com.citi.dataanalytics.classes.GetRecordByDay;
import com.citi.dataanalytics.classes.GetStockName;
import com.citi.dataanalytics.classes.Readdata;
import com.citi.dataanalytics.classes.Record;
import com.citi.dataanalytics.classes.*;
import org.apache.commons.logging.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

//    @RequestMapping("/stock")
//    @ResponseBody
//    public  ArrayList<Record> getStocks(@RequestParam String start, @RequestParam String end, HttpSession session) {
//        ArrayList<String> stocks = (ArrayList<String>) session.getAttribute("stockList");
//        ArrayList<Record> records = new ArrayList<>();
//        for(String stock:stocks){
//            ArrayList<Record> tmpRecord = Readdata. acessDate(start,end,stock);
//            for(Record record:tmpRecord){
//                records.add(record);
//            }
//        }
//        return records;
//    }

    @RequestMapping("/getTheClose")
    @ResponseBody
    public ArrayList<Record> getTheClose(@RequestParam String startTime, @RequestParam String endTime, HttpSession session){
        ArrayList<String> stocks = (ArrayList<String>) session.getAttribute("stockList");
        for(String stock:stocks){
            System.out.print(stock);
        }
        ArrayList<Record> records = new ArrayList<>();
        for(String stock:stocks){
            try {
                ArrayList<Record> tmpRecord = GetRecordByDay. acessdatabyday(startTime ,endTime,stock);
                for(Record record:tmpRecord){
                    records.add(record);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return records;
    }

    @RequestMapping("/getStockByTime")
    @ResponseBody
    public ArrayList<Record> getStockByTime(@RequestParam String startDate, @RequestParam String endDate, @RequestParam int startTime, @RequestParam int endTime, HttpSession session){
        ArrayList<String> stocks = (ArrayList<String>) session.getAttribute("stockList");
        ArrayList<Record> records = new ArrayList<>();
        for(String stock:stocks){
            try {
                ArrayList<Record> tmpRecord = Readdata. acessData(startTime ,endTime,startDate, endDate, stock);
                for(Record record:tmpRecord){
                    records.add(record);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return records;
    }

    @RequestMapping("/getStockData")
    @ResponseBody
    public Map<String,String[][]> getStockData(@RequestParam String valueType,@RequestParam String startDate,@RequestParam String endDate,HttpSession session) throws IOException,java.text.ParseException{
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
                stocksData.put(stock_symbol,singleStockData);
            }
        }
        return stocksData;
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

    @RequestMapping("/analytics")
    public String analytics(){
        return "analytics";
    }

    @RequestMapping("/analyticsStock")
    @ResponseBody
    public Analysis analyticsStock(@RequestParam String startDate, @RequestParam String endDate, @RequestParam String stockName){
        try{
            return AnalysisOperation.getAnalysis(startDate,endDate,stockName);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
        //Element element = new Element(1, "20110101");
        //return new Analysis("abc", element, element, 1, element, element, 1, element, element, 1, element, element, 1);
    }

}
