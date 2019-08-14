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

}
