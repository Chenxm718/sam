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
        int x =1;
        int y=2;
        int z=3;
        System.out.println(y+=z--/++x);
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
        int a= 100;
        int b = 45;
        System.out.println(max(a,b));
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
        String voucherId = "1903060000011170701200000202";
        int hashValue = voucherId.hashCode();
        int shardCount = 32;
        System.out.println(Math.abs(hashValue % shardCount)+1);
    }
}
