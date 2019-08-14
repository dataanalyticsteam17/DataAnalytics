package com.citi.dataanalytics.Analysis;

import com.citi.dataanalytics.classes.PlotDataget;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

public class AnalysisPlotTest {

    @Test
    public void getPriceChange() {
        String start_time = "20160104", end_time = "20160304", symbol = "a";
        String[][] as = AnalysisPlot.getPriceChange(start_time,end_time,symbol);
        assertThat(as,notNullValue( String[][].class));
    }

    @Test
    public void getMaxMinChange() {
        String  start_time = "20160104", end_time = "20160304", symbol = "appl";
        String[][] as =AnalysisPlot.getMaxMinChange(start_time,end_time,symbol);
        assertThat(as,notNullValue( String[][].class));
    }
}