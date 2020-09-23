package sam.test;

import org.junit.Test;

import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author:ChenXinmin
 * @Date:2019/6/18 14:04
 */
public class TestShard {

    /**
     * 计算要分发的次数
     *
     * @param totalNum
     * @param oneNum
     * @return
     */
    private int getTotalCount(int totalNum, int oneNum) {
        int count = totalNum % oneNum == 0 ? totalNum / oneNum : totalNum / oneNum + 1;
        if (oneNum >= totalNum) {
            count = 1;
        }
        return count;
    }
    @Test
    public void testInit(){
//        LocalDateTime startTime = LocalDateTime.now();
//        LocalDateTime endTime = startTime.plusSeconds(1l);
//        Duration duration = Duration.between(startTime,endTime);
//        System.out.println(duration.toMillis());
        long time = 1578560524l;
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String sd = sdf.format(new Date(time));
        Instant instant = Instant.ofEpochSecond(time);
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime ss = LocalDateTime.ofInstant(instant, zone);
        System.out.println(ss);
//        //生码总数量
//        int totalNum = 50000;
//        //单次分发数量
//        int oneNum = 10000;
//        //需要分多少次进行处理
//        int totalCount = getTotalCount(totalNum, oneNum);
//        for (int i = 0; i < totalCount; i++) {
//            int start = (i * oneNum + 1);
//            int end = (oneNum * (i + 1));
//            end = end >= totalNum ? totalNum : end;
//            System.out.println("start:"+start+"end:"+end+"=="+(i+1)+"===count=="+totalCount);
//        }
    }
    @Test
    public void testShard(){
//        LocalDateTime tt = LocalDateTime.now().minusDays(1l);
//        System.out.println(tt);
//        System.out.println(tt.isBefore(LocalDateTime.now()));
        System.out.println(Math.abs(("1719149186656669589").hashCode())%32 +1);
        System.out.println(Math.abs(("9847724131857091987").hashCode())%32 +1);
        System.out.println(Math.abs(new Long(1009527380).hashCode())%32 +1);
        System.out.println(Math.abs(("15047250012").hashCode())%32 +1);
        String ss = "2020-08-27 00:00:00.0";
        System.out.println(ss.substring(0,19));
        System.out.println(LocalDate.parse("2020-01-01"));
        System.out.println(LocalDateTime.parse(ss.substring(0,19),DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));


    }

    @Test
    public void testSql(){
//        readAndWriteTxt();
//        String str = "001807022018|051101392018";
//        String[] strings = str.split("\\|");
//        System.out.println(strings.length);
//        System.out.println(str.split("\\|")[0]);

//        Integer dateInt = Integer.valueOf(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMM")));
//        System.out.println(dateInt-8);
        System.out.println(String.format("init_file_nsq_biz_%s_%s", 1, 2));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("=sfsda").append("sadfaf").append(",");
        System.out.println(stringBuilder.toString().substring(0,stringBuilder.toString().length()-1));
    }

    private String shared(String memberNo){
       int shared =  Math.abs(memberNo.hashCode()%32) +1;
       return String.format("%02d",shared);
    }

    private String initSql(String sharedName ,String memberNo,long medalId,long medalEquityId){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT INTO cmc_member_medal");
        stringBuilder.append(sharedName);
        stringBuilder.append(".equity_hive_data(member_no,medal_id,medal_equity_id,reach_time,is_get) VALUES(");
        stringBuilder.append("'").append(memberNo).append("'");
        stringBuilder.append(",").append(medalId).append(",").append(medalEquityId).append(",").append("NOW(),1);");
        return stringBuilder.toString();
    }

    private void readAndWriteTxt(){
        try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw
            /* 读入TXT文件 */
            String pathname = "D:\\temp\\1.txt"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
            /* 写入Txt文件 */
            File writename = new File("D:\\temp\\2.txt"); // 相对路径，如果没有则要建立一个新的output。txt文件

            File writename1 = new File("D:\\temp\\3.txt"); // 相对路径，如果没有则要建立一个新的output。txt文件

            File filename = new File(pathname); // 要读取以上路径的input。txt文件
            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream(filename)); // 建立一个输入流对象reader
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            String line = "";
            line = br.readLine();
            writename.createNewFile(); // 创建新文件
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));
            BufferedWriter out1 = new BufferedWriter(new FileWriter(writename1));
            while (line != null) {
                line = br.readLine(); // 一次读入一行数据
                if (line!=null){
                    String sql = initSql(shared(line.trim()),line.trim(),159,183);
                    out.write(sql+"\r\n");
                    out1.write(line.trim()+"\r\n");
                }

            }
            out.flush();
            out1.flush();
//            out.close();
//            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPage(){
//
        int minGroup = 1;
        int pageSize = 300;
        int countPage = (minGroup%pageSize)>0?(minGroup/pageSize)+1:(minGroup/pageSize);
        System.out.println(countPage);
        for(int i=0;i<countPage;i++){
            System.out.println("index:"+(i-1+1)*pageSize + "------"+"pageSize"+pageSize);
        }
    }


    @Test
    public void testSub(){
        List<String> list = new ArrayList<>();
        for (int i = 0;i<22;i++){
            list.add((i+1)+"");
        }
        System.out.println(list.get(list.size()-1));
        int pageIndex = 3;
        int pageSize = 10;
        int start = (pageIndex-1)*pageSize;
        int end = pageIndex*pageSize;
        System.out.println("=============="+end);
        if (end>list.size()){
            end = list.size();
        }
        System.out.println(start+"  "+ end);
        List<String> list1 = list.subList(start,end);
        System.out.println(list1.get(0));
        System.out.println(list1.size());
        System.out.println(list1.get(list1.size()-1));
//        Map<String,List<String>> map = new HashMap<>();
//        map.put("321",list);
////        List<String> newList = list.stream().map(item->{return item;}).collect(Collectors.toList());
////        newList.forEach(ss-> System.out.println(ss));
//////        int num = 2;
////        for(int j=1;j<4;j++){
////            for(int k=0;k<1;k++){
////                System.out.println(list.subList((j-1)*num,((j-1)*num)+num));
////            }
////        }
//        int PAGE_SIZE = 5;
//        int totalNumber = 19986;
//        int countPage = (totalNumber%PAGE_SIZE)>0?(totalNumber/PAGE_SIZE)+1:(totalNumber/PAGE_SIZE);
//        System.out.println(countPage);
//        System.out.println((PAGE_SIZE*(countPage-1)));
//        System.out.println(totalNumber-(PAGE_SIZE*(countPage-1)));
//        for(int j=1;j<=list.size();j++){
//            for(int k=0;k<1;k++){
//                map.get("321").subList((j-1)*1,(j-1)*1+1);
//            }
//        }




    }

    @Test
    public void testMapSort(){
        Map<String,String> map = new HashMap<>();
        map.put("cinemaGovCode","1234556");
        map.put("showCode","C189083098908908");
        map.put("seatRow","1");
        map.put("seatColumn","2");
        map.put("sellOrderId","12324");
        map.put("signType","md5");
        map.put("ticketCode","543543541");
        map.put("movieShowStartTime","223321");

        Ksort(map);
        System.out.println(singSort(map));
    }
    public static void Ksort(Map<String, String> map) {
        String sb = "";
        String[] key = new String[map.size()];
        int index = 0;
        for (String k : map.keySet()) {
            key[index] = k;
            index++;
        }
        Arrays.sort(key);
        for (String s : key) {
            sb += s + "=" + map.get(s) + "&";
        }
        sb = sb.substring(0, sb.length() - 1);
// 将得到的字符串进行处理得到目标格式的字符串
//        try {
//            sb = URLEncoder.encode(sb, "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }// 使用常见的UTF-8编码
//        sb = sb.replace("%3D", "=").replace("%26", "&");
        System.out.println(sb);
    }

    public static String singSort(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        String[] key = new String[map.size()];
        int index = 0;
        for (String k : map.keySet()) {
            key[index] = k;
            index++;
        }
        Arrays.sort(key);
        for (String s : key) {
            sb.append(s).append("=").append( map.get(s)).append("&");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }


    @Test
    public void testSale(){
//        String[] str = {"19110400000000001000","19103000000000001002","19110400000000001001","19110400000000001002","19110126192000001000","19110401304000001000","19101701304000001000","19103135071000001000","19110166040000001004","19110466040000001000","19110466040000001001","19110259263000001000","19110427092000001000","19103027092000001000","19110133099000001003","19110403353000001000","19110430327000001000","19110430327000001002","19102503353000001002","19102503353000001001","19101103353000001001","19101103353000001000","19110427091000001000","19110101002000001002","19110101002000001000","19110101002000001001","19110406324000001001","19110413032000001000","19110413032000001001","19110426320000001002","19110575887000001000","19110403809000001000","19110103809000001002","19110510381000001000","19110410381000001001","19103104903000001005","19110575250000001000","19110575250000001001","19110575250000001002","19110503325000001000","19110234884000001000","19110404880000001000","19103004880000001001","19103004880000001000","19110204880000001000","19103131376000001003","19110104871000001001","19110527223000001000","19110404871000001002","19110527223000001001","19110175509000001000","19110407307000001001","19110243935000001000","19110401311000001000","19110473097000001002","19103138406000001000","19110438406000001001","19110503314000001000","19110426927000001000","19100904155000001002","19101404155000001000","19110444894000001002","19110506076000001000","19110425301000001007","19110425301000001002","19110373896000001000","19101607967000001001","19102207967000001006","19110401020000001000","19110101020000001001","19110573029000001000","19110119109000001003","19110405038000001001","19110119109000001004","19110219109000001000","19110519109000001003","19110451308000001000","19102805038000001000","19110525301000001003","19110104902000001018","19110104902000001019","19101203314000001000","19091803314000001000","19101403314000001003","19110504010000001001","19101814224000001000","19091614224000001000","19110444246000001000","19110413985000001001","19110403325000001001","19110403325000001003","19102503325000001000","19102503325000001001","19102925972000001000","19110159265000001000","19110159265000001001","19110575887000001001","19110412342000001001","19110430282000001000","19110525383000001004", "19110403946000001001","19110512066000001000","19110515005000001000","19110404085000001002","19110403946000001000","19110438968000001000","19102327347000001001","19110131812000001000","19102113165000001000","19103028838000001000","19110529819000001000","19110114344000001013","19110314344000001000","19110526921000001001","19110427920000001000","19102227920000001000","19110427093000001000","19102419953000001000","19110415005000001001","19110415005000001003","19110515005000001001","19110415005000001002","19110527512000001000","19110527512000001001","19100915366000001003","19103026191000001000","19110504902000001001","19110219368000001000","19110466426000001002","19110466426000001003","19110466426000001004","19110466426000001001","19110113985000001001","19110466426000001000","19110113985000001000","19110475868000001000","19110226921000001000","19110343254000001000","19110438065000001001","19103106324000001005","19103004085000001001","19103004085000001002","19110119393000001001","19110104903000001003","19110104903000001002","19110519953000001000","19110333355000001000","19110343242000001000","19110527512000001002","19110527512000001003","19110527512000001004","19110528838000001001","19110528838000001000","19110413135000001000","19110514403000001001","19110514403000001000","19110407924000001001","19110407924000001002","19110413165000001000","19110426320000001000","19110503241000001000","19110527153000001000","19101603314000001000","19110535120000001000","19110475019000001001","19110438203000001000","19102612398000001001","19110444084000001000","19110544084000001000","19110515042000001000","19110526232000001000","19110538968000001000","19110538968000001001","19110427222000001000","19110527222000001001","19110535941000001000","19110503309000001000","19102803353000001001","19110515818000001000","19110512423000001000","19110533080000001000","19110533080000001001","19103008164000001001","19110543323000001000","19110433969000001003","19110533969000001002","19110544975000001001","19110504010000001004","19110504010000001003","19110504010000001002","19110413825000001000","19110594193000001000","19110411132000001000","19110505169000001000","19110506324000001001","19110535072000001000","19110435072000001004","19110435072000001005","19102803867000001001","19110503867000001001",	 "19110503867000001000","19110403867000001000","19110226870000001000","19100826870000001002","19100826870000001001","19110426870000001002","19110543057000001000","19110514344000001005"};
//        for (int i=0;i<str.length;i++) {
//            if ((Math.abs((str[i]).hashCode())%32 +1)==10 ||(Math.abs((str[i]).hashCode())%32 +1)==11 ){
//                System.out.println(str[i]);
//            }
//        }
//        StringBuilder a = new StringBuilder();
//        a.append("111");
//        String b = "222";
//        for (int i=0;i<2;i++){
////
//            b = "0"+b;
//            StringBuilder stringBuilder = new StringBuilder();
//            stringBuilder.append("0");
//            a = stringBuilder.append(a);
//            System.out.println(a.toString());
//            System.out.println(b);
//        }
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.toString());

        String str = "2020-07-08T02:30:01.0";
        System.out.println(str.substring(0,19));
        LocalDateTime dateTime = LocalDateTime.parse(str.substring(0,19));
        System.out.println(dateTime);
    }
}
