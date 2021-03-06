package com.niuxuewei.springplayground.controller;

import com.niuxuewei.springplayground.domain.CustomSettings;
import com.niuxuewei.springplayground.domain.MyException;
import com.niuxuewei.springplayground.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class SimpleController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private final CustomSettings customSettings;

    @Autowired
    public SimpleController(CustomSettings customSettings) {
        this.customSettings = customSettings;
    }

    @RequestMapping("/test")
    public String home() {
        return "Hello World!";
    }

    @GetMapping("/testjson")
    public User testjson() {
        return new User(11, "abc", "17615821400", new Date());
    }

    @GetMapping("/testproperties")
    public Object testProperties() {
        return customSettings;
    }

    @GetMapping("/exception")
    public Object exception() {
        throw new MyException(10, "11");
    }

}
