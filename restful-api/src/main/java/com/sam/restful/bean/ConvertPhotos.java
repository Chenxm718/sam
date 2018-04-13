package com.sam.restful.bean;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class ConvertPhotos {
    private String fileId;
    private String srcFileId;
    private byte[] photo;
    private LocalDateTime createTime;
    private String photoName;
    private String cutUrl;
    private PhotoBean photoBean;
    private boolean cutFlag;
}
