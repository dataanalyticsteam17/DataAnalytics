package com.citi.dataanalytics.classes;
import java.io.File;
import java.util.ArrayList;

public class GetStockName {
//    public static void  main(String[] args )throws IOException, java.text.ParseException {
//       // String ps= "C:\\Users\\jw\\Desktop\\DataAnalysis\\Data Analytics\\Test Data\\Quant Quote Market Data - Jan to Mar 2016\\allstocks_";
//        String ps1= "C:\\Users\\jw\\Desktop\\DataAnalysis\\Data Analytics\\Test Data\\" +
//                "Quant Quote Market Data - Jan to Mar 2016\\allstocks_20160104";
//        ArrayList<String> files = new ArrayList<String>();
//        getAllFileName(ps1, files);
//        getchar(files);
//        for (String s:files){
//            System.out.println(s);
//        }
//
//       // removeDuplicateWithOrder(files);
//
//    }
    public static ArrayList<String> getstock(){
        String ps1= "C:\\Users\\jw\\Desktop\\DataAnalysis\\Data Analytics\\Test Data\\" +
                "Quant Quote Market Data - Jan to Mar 2016\\allstocks_20160104";
        ArrayList<String> files = new ArrayList<String>();
        getAllFileName(ps1, files);
        getchar(files);
        for (String s:files){
            System.out.println(s);
        }
        return files;
    }
    public static void getAllFileName(String path, ArrayList<String> fileNameList) {

        boolean flag = false;
        File file = new File(path);
        File[] tempList = file.listFiles();
        //System.out.println(tempList.toString());
        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
             //System.out.println("文     件：" + tempList[i]);
                //fileNameList.add(tempList[i].toString());
                fileNameList.add(tempList[i].getName());
            }
        }

    }
    // 删除ArrayList中重复元素，保持顺序
//    public static void removeDuplicateWithOrder(ArrayList list) {
//        Set set = new HashSet();
//        List newList = new ArrayList();
//        for (Iterator iter = list.iterator(); iter.hasNext();) {
//            Object element = iter.next();
//            if (set.add(element))
//                newList.add(element);
//        }
//        list.clear();
//        list.addAll(newList);
//        System.out.println( " remove duplicate " + list);
//    }
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
