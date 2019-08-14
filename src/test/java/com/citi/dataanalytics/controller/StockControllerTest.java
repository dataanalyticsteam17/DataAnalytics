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
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockControllerTest {

    MockMvc mockMvc;
    MockHttpSession session;

    @Autowired
    StockController stockController;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        session = new MockHttpSession(); //2.初始化
    }

    @Test
    public void getAllStockName() {
        List<String> arrayList = stockController.getAllStockName();
        Assert.assertNotNull(arrayList);
    }

    @Test
    public void selectStock() {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("a");
        arrayList.add("aa");
        stockController.selectStock(arrayList, session);
        Assert.assertNotNull(session.getAttribute("stockList"));
    }
}