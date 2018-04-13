package com.sam.restful.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class BigDataPtoto {
    private String orderId;
    private String cinemaId;
    private List<String> codeIds;//票号 ticketNo
    private int dataType; //1:机器识别 2：人工校准
    private List<Photos> photos;
}
