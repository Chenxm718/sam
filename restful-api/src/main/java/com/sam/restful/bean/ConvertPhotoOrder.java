package com.sam.restful.bean;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
public class ConvertPhotoOrder {
    private String checkCode;
    private String cinemaCode;
    private String mobile;
    private String orderId; //pos订单号
    private List<String> ticketIdList; //票号列表
    private List<String> goodsIdList;
    private List<ConvertPhotos> photos;
    private LocalDateTime createTime;
}
