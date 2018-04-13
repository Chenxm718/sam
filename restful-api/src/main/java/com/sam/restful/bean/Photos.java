package com.sam.restful.bean;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Photos {
    private int age;
    private int sex;//1:女，2男 -1 未识别
    private int ethnic;// 1亚洲人 2白人 3黑人 -1未识别
    private float score;
    private String photoTime;//代表拍照时间  格式为 yyyy-mm-dd HH:MM:SS
}
