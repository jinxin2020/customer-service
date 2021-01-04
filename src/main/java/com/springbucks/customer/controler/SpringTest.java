package com.springbucks.customer.controler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringTest {
    @RequestMapping("test")
    public String hello(){
        return "helloworld";
    }
}
