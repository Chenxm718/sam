package com.sam.restful.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PhotoBean {
    private String image_id;
    private String request_id;
    private List<Faces> faces;
}
