package com.citi.dataanalytics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping("/home")
    public String home(){
        return "home";
    }

    @RequestMapping("/select")
    public String select() {return "select";}

    @RequestMapping("/plot")
    public String plot() {return "plot";}

    @RequestMapping("/analytics")
    public String analytics(){
        return "analytics";
    }
}
