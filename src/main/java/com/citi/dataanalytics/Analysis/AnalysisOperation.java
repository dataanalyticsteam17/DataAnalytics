package com.citi.dataanalytics.Analysis;


import com.citi.dataanalytics.classes.Readdata;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/*
* 本类中包含两个方法：
* （1）getAnalysis，该方法用于获取某一时间段的股票分析结果，结果存储于一个Analysis对象中：
* Analysis对象属性：
//String stock_name, 股票名
// Element high_price, 最高价
// Element low_price, 最低价
// float avg_price, 平均价格
// Element high_priceup, 最高涨幅
// Element low_pricedown, 最低涨幅
// float avg_pricechange, 价格平均变化幅度
// Element high_diff, 最高价差
// Element low_diff, 最小价差
// float avg_diff,平均价差
// Element high_volume,最大交易量
// Element low_volume,最小交易量
// float avg_volume) 平均交易量
* 输出结果样例：(String start_time = "20160104", end_time = "20160304", symbol = "a";）
*Analysis{stock_name='a', high_price=Element{value=40.72, date='20160106'}, low_price=Element{value=34.8, date='20160208'}, avg_price=37.600925, high_priceup=Element{value=4.264749, date='20160129'}, low_pricedown=Element{value=-4.21169, date='20160107'}, avg_pricechange=-0.060530752, high_diff=Element{value=9.726622, date='20160217'}, low_diff=Element{value=0.991157, date='20160229'}, avg_diff=2.8002658, high_volume=Element{value=1.05290392E8, date='20160208'}, low_volume=Element{value=7618650.0, date='20160120'}, avg_volume=2.3530654E7}

* （2）get_AnalysisRecord_list：该方法用于获取一段时间内带有每日高价差、价格涨跌的值的
* AnanlysiRecord的一个Arraylistd对象，可用于构造股票分析表
* AnanlysiRecord属性：
*String stock_name, 股票名
* String date, float open, float high, float low, float close, float volume,
* float price_diff, 价格相对前一日收盘价的变化幅度
* float max_min  当日高低差
*
* 输出结果样例：（String start_time = "20160104", end_time = "20160304", symbol = "a";）
* AnalysisRecord{stock_name='a', date='20160104', open=41.08, high=41.19, low=40.34, close=40.68, volume=6.1365528E7, price_diff=0.0, max_min=2.107086}
AnalysisRecord{stock_name='a', date='20160105', open=40.73, high=40.95, low=40.34, close=40.55, volume=2.255448E7, price_diff=-0.31956998, max_min=1.5121483}
......
* */
public class AnalysisOperation {
    public static void main(String[] args) {
        String start_time = "20160104", end_time = "20160304", symbol = "a";
//        Analysis analysis = getAnalysis(start_time,end_time,symbol);
//        System.out.println(analysis.toString());
        ArrayList<AnalysisRecord> ls = get_analysisrecord(start_time,end_time,symbol);
        for (AnalysisRecord ar :ls){
            System.out.println(ar.toString());
        }
    }


    public static Analysis getAnalysis(String start_date, String end_date,String symbol) {
        ArrayList<AnalysisRecord> ls = get_analysisrecord(start_date, end_date,symbol);

        Element high_price=new Element(Float.MIN_VALUE," ");
        Element low_price=new Element(Float.MAX_VALUE," ");
        float sum_price=0;

        Element high_priceup=new Element(Float.MIN_VALUE," ");
        Element  low_pricedown=new Element(Float.MAX_VALUE," ");
        float sum_pricechange=0;

        Element high_diff=new Element(Float.MIN_VALUE," ");
        Element low_diff=new Element(Float.MAX_VALUE," ");
        float sum_diff=0;

        Element high_volume=new Element(Float.MIN_VALUE," ");
        Element low_volume=new Element(Float.MAX_VALUE," ");
        float sum_volume=0;


        for (int i=0;i<ls.size();i++){
            AnalysisRecord record = ls.get(i);
            sum_price=sum_price+record.getClose();
            sum_volume=sum_volume+record.getVolume();
            sum_pricechange = sum_pricechange+record.getPrice_diff();
            sum_diff = sum_diff +record.getMax_min();

                if (record.getClose()>high_price.getValue()) {
                    high_price.setValue(record.getClose());
                    high_price.setDate(record.getDate());
                }
                if (record.getClose()<low_price.getValue()){
                    low_price.setValue(record.getClose());
                    low_price.setDate(record.getDate());
                }

                if (record.getVolume()>high_volume.getValue()) {
                    high_volume.setValue(record.getVolume());
                    high_volume.setDate(record.getDate());
                }
                if (record.getVolume()<low_volume.getValue()) {
                    low_volume.setValue(record.getVolume());
                    low_volume.setDate(record.getDate());
                }

                if (record.getPrice_diff()>high_priceup.getValue()){
                    high_priceup.setValue(record.getPrice_diff());
                    high_priceup.setDate(record.getDate());
                }
                if (record.getPrice_diff()<low_pricedown.getValue()){
                    low_pricedown.setValue(record.getPrice_diff());
                    low_pricedown.setDate(record.getDate());
                }


                if (record.getMax_min()>high_diff.getValue()){
                    high_diff.setValue(record.getMax_min());
                    high_diff.setDate(record.getDate());
                }
                if (record.getMax_min()<low_diff.getValue()){
                    low_diff.setValue(record.getMax_min());
                    low_diff.setDate(record.getDate());
                }

        }

        return new Analysis(symbol
                ,high_price,low_price,sum_price/ls.size()
                ,high_priceup,low_pricedown,sum_pricechange/ls.size()
                ,high_diff,low_diff,sum_diff/ls.size()
                ,high_volume,low_volume,sum_volume/ls.size());
    }
//public static ArrayList<AnalysisRecord> get_AnalysisRecord_list(String start_date, String end_date,String symbol)
//        throws IOException,java.text.ParseException{
//    ArrayList<AnalysisRecord> analysisRecords = get_analysisrecord(start_date, end_date,symbol);
//    return analysisRecords;
//}
    public static ArrayList<AnalysisRecord> get_analysisrecord(String start_date, String end_date,
                                                               String symbol) {
        ArrayList<AnalysisRecord> records = new ArrayList<AnalysisRecord>();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            Date start = sdf.parse(start_date);
            Date end = sdf.parse(end_date);
            float last_day_close = 0;
            while (start.before(end) || start.equals(end)) {
                //System.out.println(sdf.format(start));
                ArrayList<String> ls = Readdata.readData(sdf.format(start), sdf.format(start), symbol);

                if (!ls.isEmpty()) {
                    //String date =" ";
                    float open = Float.parseFloat(ls.get(0).split(",")[2]);
                    float close = Float.parseFloat(ls.get(ls.size() - 1).split(",")[5]);
                    float volume = 0;
                    float high = Float.NEGATIVE_INFINITY, low = Float.POSITIVE_INFINITY;
                    for (int i = 0; i < ls.size(); i++) {
                        if (Float.parseFloat(ls.get(i).split(",")[3]) > high)
                            high = Float.parseFloat(ls.get(i).split(",")[3]);
                        if (Float.parseFloat(ls.get(i).split(",")[4]) < low)
                            low = Float.parseFloat(ls.get(i).split(",")[4]);
                        volume = volume + Float.parseFloat(ls.get(ls.size() - 1).split(",")[6]);
                    }
                    float max_min = (high - low) / low * 100;
                    if (start.equals(sdf.parse(start_date))) {
                        records.add(new AnalysisRecord(symbol, sdf.format(start), open, high, low, close, volume,
                                0,
                                max_min));
                        last_day_close = close;
                    } else {
                        records.add(new AnalysisRecord(symbol, sdf.format(start), open, high, low, close, volume,
                                (close - last_day_close) / last_day_close * 100,
                                max_min));
                        last_day_close = close;
                    }
                }

                Calendar ca = Calendar.getInstance();
                ca.setTime(start);
                ca.add(Calendar.DAY_OF_YEAR, 1);//day+1
                start = ca.getTime();
            }
        }catch (java.text.ParseException e){
            System.out.println(e.getMessage());
        }
        return records;
    }

}
