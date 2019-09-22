package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class Hello {
    //hh
    @RequestMapping(value = "/")
   public String index(){
       return "index";
          }

   }
