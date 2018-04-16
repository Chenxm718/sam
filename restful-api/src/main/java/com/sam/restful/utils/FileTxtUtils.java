package com.sam.restful.utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
public class FileTxtUtils {
//    private static String path = "D:/";
//    private static String filenameTemp;

    public static void main(String[] args) throws IOException {
        FileTxtUtils.creatTxtFile("D:\\Myself\\2\\1.txt");
        FileTxtUtils.writeTxtFile("你好","D:\\Myself\\2\\1.txt");
    }


    /**
     * 创建文件
     *
     * @throws IOException
     */
    public static boolean creatTxtFile(String path)  {
        boolean flag = false;
//        filenameTemp = path + name + ".txt";
        File filename = new File(path);
        if (!filename.exists()) {
            try {
                filename.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            flag = true;
        }
        return flag;
    }

    /**
     * 写文件
     *
     * @param newStr
     *            新内容
     * @throws IOException
     */
    public static boolean writeTxtFile(String newStr,String path){
        // 先读取原有文件内容，然后进行写入操作
        boolean flag = false;
        String filein = newStr + "\r\n";
        String temp = "";

        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        FileOutputStream fos = null;
        PrintWriter pw = null;
        try {
            // 文件路径
            File file = new File(path);
            // 将文件读入输入流
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            StringBuffer buf = new StringBuffer();

            // 保存该文件原有的内容
            for (int j = 1; (temp = br.readLine()) != null; j++) {
                buf = buf.append(temp);
                // System.getProperty("line.separator")
                // 行与行之间的分隔符 相当于“\n”
                buf = buf.append(System.getProperty("line.separator"));
            }
            buf.append(filein);

            fos = new FileOutputStream(file);
            pw = new PrintWriter(fos);
            pw.write(buf.toString().toCharArray());
            pw.flush();
            flag = true;
        } catch (IOException e1) {
            // TODO 自动生成 catch 块
            try {
                throw e1;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            if (pw != null) {
                pw.close();
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }
}
