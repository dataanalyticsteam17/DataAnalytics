package com.citi.dataanalytics.classes;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

public class PlotDatagetTest {
    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Test
    public void getPlotData() {
        String value_name = "Open Price", start_time = "20160104", end_time = "20160304", symbol = "a";
        String[][] as = PlotDataget.getPlotData(value_name,start_time,end_time,symbol);
        assertThat(as,notNullValue( String[][].class));
    }

    @Test
    public void getDataofday() {
        String value_name = "Open Price", day = "20160104", symbol = "appl";
        String[][] as = PlotDataget.getDataofday(value_name,day,symbol);
        assertThat(as,notNullValue( String[][].class));
    }

    @Test
    public void getDataoftime(){
        String value_name = "Close Price", start_time = "20160104", end_time = "20160304", symbol = "appl";
        String[][] as = PlotDataget.getDataoftime(value_name,start_time,end_time,symbol);
        assertThat(as,notNullValue( String[][].class));
    }

    @Test
    public void return_index() {
        assertEquals(2,PlotDataget.return_index("Open Price"));
    }
}