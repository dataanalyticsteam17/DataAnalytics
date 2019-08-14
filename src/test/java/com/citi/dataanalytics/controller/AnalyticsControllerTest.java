package com.citi.dataanalytics.controller;

import com.citi.dataanalytics.Analysis.Analysis;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnalyticsControllerTest {

    @Autowired
    AnalyticsController analyticsController;

    @Test
    public void analyticsStock() {
        Analysis analysis = analyticsController.analyticsStock("20160112", "20160314", "a");
        Assert.assertNotNull(analysis);
    }

}