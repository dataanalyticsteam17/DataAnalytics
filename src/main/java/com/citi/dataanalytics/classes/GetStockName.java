package com.citi.dataanalytics.classes;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

public class GetStockName {
    public static String absPath="C:\\Users\\jw\\Desktop\\DataAnalysis\\Data Analytics\\" +
            "Test Data\\Quant Quote Market Data - Jan to Mar 2016\\allstocks_";

//    public static void  main(String[] args ){
//        ArrayList<String> ls = getstock();
//        for (String s:ls){
//            System.out.println(s);
//        }
//    }
    public static ArrayList<String> getstock(){
            ArrayList<String> files = new ArrayList<String>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            try {
                Date start = sdf.parse("20160101");
                Date end = sdf.parse("20160630");

                while (start.before(end)) {
                    String reStr = sdf.format(start);
                    String filepath = absPath + reStr ;
                    File isfile = new File(filepath);
                    if(isfile.exists()){
                        getAllFileName(filepath, files);
                    }
                    Calendar ca = Calendar.getInstance();
                    ca.setTime(start);
                    ca.add(Calendar.DAY_OF_YEAR, 1);//day+1
                    start = ca.getTime();
                }
            }catch (java.text.ParseException e){
                System.out.println(e.getMessage());
            }

            removeDuplicateWithOrder(files);
            getchar(files);
            return  files;

    }
    public static void getAllFileName(String path, ArrayList<String> fileNameList) {
        File file = new File(path);
        File[] tempList = file.listFiles();
        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
                fileNameList.add(tempList[i].getName());
            }
        }

    }
    // 删除ArrayList中重复元素，保持顺序
    public static void removeDuplicateWithOrder(ArrayList list) {
        Set set = new HashSet();
        List newList = new ArrayList();
        for (Iterator iter = list.iterator(); iter.hasNext();) {
            Object element = iter.next();
            if (set.add(element))
                newList.add(element);
        }
        list.clear();
        list.addAll(newList);
    }
    public static void getchar(ArrayList<String> fileNameList){
        ArrayList<String> newlist = new ArrayList();
        for(String s:fileNameList){
            String stock = s.split("\\_")[1].split("\\.")[0];
            newlist.add(stock);
        }
        fileNameList.clear();
        fileNameList.addAll(newlist);
    }
}
