package com.sam.restful.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/face")
public class OperatePhoto {

    @RequestMapping(value = "operate",method = RequestMethod.POST)
    public String operateFace(){
        return null;
    }
}
