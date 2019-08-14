package com.citi.dataanalytics.controller;

import com.citi.dataanalytics.Analysis.Analysis;
import com.citi.dataanalytics.Analysis.AnalysisOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AnalyticsController {

    @RequestMapping("/analyticsStock")
    @ResponseBody
    public Analysis analyticsStock(@RequestParam String startDate, @RequestParam String endDate, @RequestParam String stockName){
        try{
            return AnalysisOperation.getAnalysis(startDate,endDate,stockName);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
