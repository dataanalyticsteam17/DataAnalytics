package com.citi.dataanalytics.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlotControllerTest {

    MockMvc mockMvc;
    MockHttpSession session;

    @Autowired
    PlotController plotController;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        session = new MockHttpSession();
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("a");
        session.setAttribute("stockList", arrayList);
    }

    @Test
    public void getStockData() {
        String valueType="Open Price";
        String startDate="20160107";
        String endDate="20160114";
        Map<String,String[][]> stockData=plotController.getStockData(valueType, startDate,endDate,session);
        Assert.assertNotNull(stockData);
    }

    @Test
    public void getAnalyticsData() {
        String startDate="20160107";
        String endDate="20160214";
        String stockSymbol="aap";
        Map<String,String[][]> analyticsData=plotController.getAnalyticsData(startDate,endDate,stockSymbol);
        Assert.assertNotNull(analyticsData);
    }
}