package com.sam.restful.bean;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FaceQuality {
    private float threshold;
    private float value;//人脸质量判断结果
}
