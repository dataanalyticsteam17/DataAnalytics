package com.citi.dataanalytics.controller;

import com.citi.dataanalytics.classes.Record;
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

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecordControllerTest {

    MockMvc mockMvc;
    MockHttpSession session;

    @Autowired
    RecordController recordController;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        session = new MockHttpSession(); //2.初始化
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("a");
        arrayList.add("aa");
        session.setAttribute("stockList", arrayList);
    }


    @Test
    public void getTheClose() {

        ArrayList<Record> records = recordController.getTheClose("20160104", "20160314", session);
        Assert.assertNotNull(records);
    }

    @Test
    public void getStockByTime() {
        ArrayList<Record> records = recordController.getStockByTime("20160104", "20160106", 930, 930, session);
        Assert.assertNotNull(records);
    }
}