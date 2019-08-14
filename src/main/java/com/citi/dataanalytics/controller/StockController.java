package com.citi.dataanalytics.controller;

import com.citi.dataanalytics.classes.GetStockName;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StockController {

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
