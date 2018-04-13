package com.sam.restful.bean;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorMessage {
    private String time_used;
    private String error_message;
    private String request_id;
}
