package com.citi.dataanalytics.controller;

import com.citi.dataanalytics.classes.GetRecordByDay;
import com.citi.dataanalytics.classes.GetStockName;
import com.citi.dataanalytics.classes.Readdata;
import com.citi.dataanalytics.classes.Record;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RecordController {

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
        ArrayList<Record> records = new ArrayList<>(); // newArrayList《Record》
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

}
