package sam.test;

import org.junit.Test;

import java.io.*;

/**
 * @Author:ChenXinmin
 * @Date:2019/6/18 14:04
 */
public class TestShard {

    @Test
    public void testShard(){
        System.out.println(Math.abs((2+"12").hashCode())%32 +1);
        System.out.println(Math.abs((2+"13").hashCode())%32 +1);
        System.out.println(Math.abs((2+"14").hashCode())%32 +1);
        System.out.println(Math.abs((2+"15").hashCode())%32 +1);
        System.out.println(Math.abs((2+"16").hashCode())%32 +1);
        System.out.println(Math.abs((2+"21").hashCode())%32 +1);
        System.out.println(Math.abs((2+"22").hashCode())%32 +1);

        System.out.println(Math.abs((1+"12").hashCode())%32 +1);
        System.out.println(Math.abs((2+"15").hashCode())%32 +1);
        System.out.println(Math.abs(("19071700000111707004").hashCode())%32 +1);
        System.out.println(Math.abs("223".hashCode()%16) +1);
        System.out.println(String.format("%02d",Math.abs((3+"9091111111").hashCode())%32 +1));

    }

    @Test
    public void testSql(){
        readAndWriteTxt();
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
}
