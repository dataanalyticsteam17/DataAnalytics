package com.citi.dataanalytics.classes;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

public class GetStockNameTest {

    @Test
    public void getstock() {
        ArrayList<String> ls = GetStockName.getstock();
        assertThat(ls, notNullValue(ArrayList.class));
    }

    @Test
    public void getAllFileName() {
        String path="C:\\Users\\jw\\Desktop\\DataAnalysis\\Data Analytics\\Test Data\\" +
                "Quant Quote Market Data - Jan to Mar 2016\\allstocks_20160104";
        ArrayList<String> ls = new ArrayList<String>();
        GetStockName.getAllFileName(path,ls);
        assertTrue(!ls.isEmpty());
    }

    @Test
    public void removeDuplicateWithOrder() {
        ArrayList<String> str =new ArrayList<String> ();
        str.add("aaa");
        str.add("aaa");
        GetStockName.removeDuplicateWithOrder(str);
        assertEquals(1,str.size());
    }

    @Test
    public void getchar() {
        ArrayList<String> str =new ArrayList<String> ();
        str.add("table_a.csv");
        str.add("table_adbe.csv");
        GetStockName.getchar(str);
        assertEquals("a",str.get(0));
        assertEquals("adbe",str.get(1));
    }
}