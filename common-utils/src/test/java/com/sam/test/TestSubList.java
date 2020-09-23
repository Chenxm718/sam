package com.sam.test;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Created by ChenXinmin on 2017/2/10.
 */
public class TestSubList {
    @Test
    public void testSubList(){
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");
        list1.add("5");
        int k = 0;
        Map<Integer,List<String>> map = new HashMap<>();
        for(int i =0;i<list1.size();i+=4){
            List<String> l ;
            if(i+4>list1.size()){
                l = list1.subList(i,list1.size());

            }else{
                l = list1.subList(i,i+4);
            }
            map.put(k,l);
            k++;
        }
        System.out.println( map.size());
        map.entrySet().forEach(e->{
            System.out.println("遍历set");
            System.out.println(e.getValue().toString());
            e.getValue().forEach(str->{
                System.out.println(str);
            });
        });
    }
    @Test
    public void testSplit(){
        String s = "1";
        System.out.println(Arrays.asList(s.split(",")));
    }

    @Test
    public void testDate(){
        LocalDateTime startDate = LocalDateTime.of(LocalDate.now().minusDays(30), LocalTime.MIN);
        System.out.println(startDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println(startDate.toLocalDate());
        System.out.println(startDate.toLocalDate().isBefore(LocalDate.parse("2017-09-02")));
        System.out.println("test"+"_"+ startDate.format(DateTimeFormatter.ofPattern("yyyyMM")));
    }

    @Test
    public void test2(){
        LocalDateTime  buyTime = LocalDateTime.now();
        LocalDateTime startTime = buyTime.plusDays(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
        LocalDateTime endTime = startTime.plusDays(1).withHour(23).withMinute(59).withSecond(59).withNano(0).minusDays(1l);
        LocalDateTime ss = startTime.plusDays(1 + 1l).plusSeconds(-1L);
        System.out.println(buyTime);
        System.out.println(startTime);
        System.out.println(endTime);
        System.out.println(ss);
    }

    @Test
    public void test3(){
        int a=100;
        double result = 0.0;
        for(int i=1;i<=a;i++){
            result+=1/i;
        }
        System.out.println(result);
    }

//    public class count100(){
//        public static void main(String[] args) {
//            int a=100;
//            double result = 0.0;
//            for(int i=1;i<=a;i++){
//                result+=1/i;
//            }
//            System.out.println(result);
//        }
//    }

    //每行输入一个数值，输入多个数值
    public  static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] a = new int[10];
        int count = 0;
        System.out.println("请输入10个整数");
        while (true) {
            if(scanner.hasNextInt()){
                a[count++] = scanner.nextInt();
            }
            if(count==10){
                for (int i = a.length-1; i >= 0; i--) {
                    System.out.println(a[i]);
                }
                break;
            }
        }
    }


    @Test
    public void test4(){
        String dt = "2020-05-01";
        String string = dt.replaceAll("/","-");
        LocalDate date = LocalDate.parse(string,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(date);
    }

    public static double max(double a,double b){
        if (a>b){
            return a;
        }else {
            return b;
        }
    }

    @Test
    public void testShard(){
//        Integer i = 8;
//        System.out.println(i%8);
//        System.out.println(i.hashCode()%8);
        String voucherId = "E359000000186915514";
        int hashValue = voucherId.hashCode();
        int shardCount = 32;
        System.out.println(Math.abs(hashValue % shardCount)+1);
        String s = null;
        System.out.println(s==null);
    }
    @Test
    public void testSubTList(){
        int pageSize = 5;
        List<Integer> logicIdList = new ArrayList<>();
        logicIdList.add(1);
        logicIdList.add(2);
        logicIdList.add(3);
        logicIdList.add(4);
        logicIdList.add(5);
        logicIdList.add(6);
        logicIdList.add(7);
        logicIdList.add(8);
        if (logicIdList.size()>=pageSize){
            int length = logicIdList.size();
            // 计算可以分成多少组
            int num = (length + pageSize - 1) / pageSize;
            for (int i = 0; i < num; i++) {
                // 开始位置
                int fromIndex = i * pageSize;
                // 结束位置
                int toIndex = (i + 1) * pageSize < length ? (i + 1) * pageSize : length;

                System.out.println(logicIdList.subList(fromIndex, toIndex));
            }

        }
    }

}
