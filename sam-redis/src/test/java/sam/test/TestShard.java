package sam.test;

import org.junit.Test;

import java.io.*;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author:ChenXinmin
 * @Date:2019/6/18 14:04
 */
public class TestShard {

    @Test
    public void testShard(){
//        System.out.println(Math.abs((2+"12").hashCode())%32 +1);
//        System.out.println(Math.abs((2+"13").hashCode())%32 +1);
//        System.out.println(Math.abs((2+"14").hashCode())%32 +1);
//        System.out.println(Math.abs((2+"15").hashCode())%32 +1);
//        System.out.println(Math.abs((2+"16").hashCode())%32 +1);
//        System.out.println(Math.abs((2+"21").hashCode())%32 +1);
//        System.out.println(Math.abs((2+"22").hashCode())%32 +1);

        System.out.println(Math.abs((1+"6").hashCode())%32 +1);
        System.out.println(Math.abs((3+"93-voucher").hashCode())%32 +1);
        System.out.println(Math.abs((3+"80-voucher").hashCode())%32 +1);
        System.out.println(Math.abs((3+"89-voucher").hashCode())%32 +1);
        System.out.println(Math.abs((3+"87-voucher").hashCode())%32 +1);
        System.out.println(Math.abs((3+"84-voucher").hashCode())%32 +1);
        System.out.println(Math.abs((7+"TM201909190005-4").hashCode())%32 +1);

        System.out.println(Math.abs(("19091700000000001010").hashCode())%32 +1);
        System.out.println(Math.abs("500".hashCode()%16) +1);
        System.out.println(String.format("%02d",Math.abs((3+"9091111111").hashCode())%32 +1));


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
        int pageSize = 2;
        int countPage = (minGroup%pageSize)>0?(minGroup/pageSize)+1:(minGroup/pageSize);
        System.out.println(countPage);
        for(int i=0;i<countPage;i++){
            System.out.println("index:"+(i-1+1)*pageSize + "------"+"pageSize"+pageSize);
        }
    }


    @Test
    public void testSub(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        List<String> newList = list.stream().map(item->{return item;}).collect(Collectors.toList());
        newList.forEach(ss-> System.out.println(ss));
//        int num = 2;
//        for(int j=1;j<4;j++){
//            for(int k=0;k<1;k++){
//                System.out.println(list.subList((j-1)*num,((j-1)*num)+num));
//            }
//        }
//        int PAGE_SIZE = 300;
//        int totalNumber = 50000;
//        int countPage = (totalNumber%PAGE_SIZE)>0?(totalNumber/PAGE_SIZE)+1:(totalNumber/PAGE_SIZE);
//        System.out.println(countPage);
//        System.out.println((PAGE_SIZE*(countPage-1)));
//        System.out.println(totalNumber-(PAGE_SIZE*(countPage-1)));



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

}
