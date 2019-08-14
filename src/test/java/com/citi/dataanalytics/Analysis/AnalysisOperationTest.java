package com.citi.dataanalytics.Analysis;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.notNullValue;


public class AnalysisOperationTest {

    @Test
    public void getAnalysis() {
        String start_time = "20160104", end_time = "20160304", symbol = "a";
        Analysis as = AnalysisOperation.getAnalysis(start_time,end_time,symbol);
        assertThat(as,notNullValue(Analysis.class));
    }


    @Test
    public void get_AnalysisRecord_list() {
        String start_time = "20160104", end_time = "20160304", symbol = "a";
        ArrayList<AnalysisRecord> as = AnalysisOperation.get_analysisrecord(start_time,end_time,symbol);
        assertThat(as,notNullValue(ArrayList.class));
    }
}