package com.citi.dataanalytics.classes;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

public class ReaddataTest {

    @Test
    public void acessData() {
        String start_date = "20160101", end_date = "20160324", symbol = "a";
        ArrayList<Record> ls= Readdata.acessData(start_date,end_date,symbol);
        assertThat(ls,notNullValue( ArrayList.class));
    }

    @Test
    public void acessData1() {
        String start_date = "20160101", end_date = "20160324";
        String start_time = "1400", end_time = "1558", symbol = "a";
        ArrayList<Record> ls= Readdata.acessData(start_time,end_time,start_date,end_date,symbol);
        assertThat(ls,notNullValue( ArrayList.class));
    }

    @Test
    public void implet_4bit_time() {
        assertEquals("0234",Readdata.implet_4bit_time("234"));
    }

    @Test
    public void acessData2() {

        String start_date = "20160101", end_date = "20160324", symbol = "a";
        int start_time = 1400, end_time = 1558;
        ArrayList<Record> ls= Readdata.acessData(start_time,end_time,start_date,end_date,symbol);
        assertThat(ls,notNullValue( ArrayList.class));
    }

    @Test
    public void readData() {
        String start_date = "20160101", end_date = "20160324", symbol = "a";
        assertThat(Readdata.readData(start_date,end_date,symbol),notNullValue(ArrayList.class));
    }

    @Test
    public void readCsv() {
        ArrayList<String> s = new ArrayList<String>();
        String path="C:\\Users\\jw\\Desktop\\DataAnalysis\\Data Analytics\\Test Data\\Quant Quote Market" +
                " Data - Jan to Mar 2016\\allstocks_20160104\\table_a.csv";
        Readdata.readCsv(s,path);
        assertTrue(s.size()>0);
    }
}