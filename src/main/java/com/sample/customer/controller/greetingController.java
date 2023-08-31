package com.sample.customer.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping(value = "/myDemo", produces = MediaType.APPLICATION_JSON_VALUE)
public class greetingController {
    @GetMapping ("/greeting") // if parameter is replaced with "/greeting" for instance -> then the greeting message will appear when entering the url localhost:8080/greeting
    public String getGreeting(){
        return "Hi it's Ayman";
    }
    @PostMapping("/emp")
    public String createEmployee(@RequestBody String emp, @RequestHeader(name = "Authorization") String auth, @RequestParam(name = "key") String val){
        return emp;
    }
}
