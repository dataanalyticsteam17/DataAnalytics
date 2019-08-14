package com.citi.dataanalytics.classes;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

public class GetRecordByDayTest {

    @Test
    public void acessdatabyday() {
       String start_time = "20160104", end_time = "20160304", symbol = "aa";
        ArrayList<Record> ls = GetRecordByDay.acessdatabyday(start_time,end_time,symbol);
        assertThat(ls, notNullValue(ArrayList.class));
    }
}