package com.sam.restful.utils;

import java.io.*;

import mtime.lark.util.lang.FaultException;
import org.springframework.util.Base64Utils;

/**
 * 将图片转换为Base64<br>
 * 将base64编码字符串解码成img图片
 */
public class Img2Base64Util {
    /**
     * 将图片转换成Base64编码
     *
     * @param imgFile 待处理图片
     * @return
     */
    public static String getImgStr(File imgFile) {
        //将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        InputStream in ;
        byte[] data = null;
        //读取图片字节数组
        try {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(Base64Utils.encodeToString(data));
    }

    /**
     * 对字节数组字符串进行Base64解码并生成图片
     *
     * @param imgStr      图片数据
     * @param imgFilePath 保存图片全路径地址
     * @return
     */
    public static boolean generateImage(String imgStr, String imgFilePath) {
        if (imgStr == null) //图像数据为空
            return false;
        try {
            //Base64解码
            byte[] b = Base64Utils.decodeFromString(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {//调整异常数据
                    b[i] += 256;
                }
            }
            //生成jpeg图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static byte[] file2byte(String filePath) {
        byte[] buffer = null;
        try {
            File file = new File(filePath);
            ByteArrayOutputStream bos;
            try (FileInputStream fis = new FileInputStream(file)) {
                bos = new ByteArrayOutputStream();
                byte[] b = new byte[8096];
                int n;
                while ((n = fis.read(b)) != -1) {
                    bos.write(b, 0, n);
                }
                fis.close();
            }
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            throw new FaultException("file not found");
        } catch (IOException e) {
            throw new FaultException("IO Exception");
        }
        return buffer;
    }

    public static final InputStream byte2Input(byte[] buf) {
        return new ByteArrayInputStream(buf);
    }

    public static void main(String[] args) {
        File imgFile = new File("D:\\Myself\\sam.jpg") ;//待处理的图片
        String imgbese=getImgStr(imgFile);
        System.out.println(imgbese.length());
        System.out.println(imgbese);
//        String imgFilePath = "d:\\332.jpg";//新生成的图片
//        generateImage(imgbese,imgFilePath);
    }


    public static String byte2Base64(byte[] bytes) {
        return new String(Base64Utils.encodeToString(bytes));
    }
}
