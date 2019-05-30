package sam.test;

import org.junit.Test;
import sam.redis.utils.RedisUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @Author:ChenXinmin
 * @Date:2019/3/5 17:15
 */
public class TestRedis {

    @Test
    public void testRedis(){
        RedisUtils.add("test_1_339","0");
        System.out.println(RedisUtils.get("test_1_339"));
    }
    @Test
    public void testRedisNx(){
        RedisUtils.setNx("test_1_339","0");
        System.out.println(RedisUtils.get("test_1_339"));
        System.out.println(RedisUtils.incr("test_1_339"));
    }
    @Test
    public void testIncr(){
        RedisUtils.incr("test_1_3310");
        System.out.println(RedisUtils.get("test_1_3310"));
        RedisUtils.incrBy("test_1_3310",-1);
        System.out.println(RedisUtils.get("test_1_3310"));
    }

    @Test
    public void testDate(){
//        LocalDateTime startTime = LocalDateTime.now().minusDays(1l);
//        LocalDateTime endTime = LocalDateTime.now().plusDays(1l);
//        LocalDate today = LocalDate.now();
//        System.out.println(startTime+" _ "+today+" _ "+startTime.toLocalDate().isAfter(today));
//        System.out.println(endTime+" _ "+today+" _ "+endTime.toLocalDate().isBefore(today));
//        System.out.println(101/3);
        System.out.println(Math.abs((1+"89").hashCode())%32 +1);
//        Arrays.asList("123".split(",")).forEach(ss->{
//            System.out.println(ss);
//        });
//        List<String> stringList = new ArrayList<>();
//        for (int i=0;i<10;i++){
//            stringList.add(i+"");
//            if (stringList.size()==3){
//                System.out.println("=========");
//                stringList.clear();
//            }
//
//        }
//        if (stringList.size()>0) {
//            System.out.println(stringList.size());
//        }
//        String str11 = "0630|1231";
//        String[] strings = str11.split("\\|");
//        List<String> expireDateList = Arrays.asList(strings);
//        List<LocalDate> expireDatimeList = new ArrayList<>();
//        expireDateList.forEach(str->{
//            String dateStr =LocalDate.now().getYear()+"-"+str.substring(0,2)+"-"+str.substring(2);
//            expireDatimeList.add(LocalDate.parse(dateStr));
//        });
//        expireDatimeList.sort(Comparator.reverseOrder());
//        expireDatimeList.forEach(date -> {
//            System.out.println(date);
//        });

    }

    @Test
    public void testPushOrPop(){

        String key = "push_key_test";
//        List<String> list1 = new ArrayList<>();
//        list1.add("51");
//
//        RedisUtils.rpush(key,list1.toArray(new String[list1.size()]));
//        System.out.println(RedisUtils.llen(key));
//        List<String> list2 = new ArrayList<>();
//        list2.add("61");
//        Long lens = RedisUtils.llen(key);
//        for(int i=1;i<=lens;i++){
//            String v = RedisUtils.lpop(key);
//            System.out.println(v);
//        }
//        RedisUtils.rpush(key,list2.toArray(new String[list2.size()]));
//        System.out.println(RedisUtils.llen(key));
        Long len = RedisUtils.llen(key);
        for(int i=1;i<=len;i++){
            String v = RedisUtils.lpop(key);
            System.out.println(v);
        }

    }
    @Test
    public void testThread(){
        try{
            Run1 run1 = new Run1();
            Run2 run2 = new Run2();
            PopRun3 popRun3 = new PopRun3();
            PopRun4 popRun4 = new PopRun4();
            run1.start();

//        run2.start();
        popRun3.start();
        popRun4.start();
            Thread.sleep(10000);
//        Thread t1 = new Thread(run1);
//        Thread t3 = new Thread(popRun3);
//        Thread t2 = new Thread(run2);
//        Thread t4 = new Thread(popRun4);
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
        }catch (Exception e){
            e.getMessage();
        }

    }
    @Test
    public void test1(){
//        Map<String,String> map = new HashMap<>();
//        for (int i=1;i<=2;i++){
//            if (map.get("test") == null){
//                map.put("test",i+"");
//            }else {
//                map.remove("test");
//            }
//        }
//        map.keySet().forEach(key->{
//            System.out.println(key);
//            System.out.println(map.get(key));
//        });
//        System.out.println(map.keySet().size());
        int i = 12;
        System.out.println(-i);
    }
}
