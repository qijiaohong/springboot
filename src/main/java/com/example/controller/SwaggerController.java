package com.example.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value="swagger访问页面",description= "swagger访问页面")
@RestController
public class SwaggerController {
    @RequestMapping("/api/swagger")
    public String toSwaggerUI(){
        return "mmnnnaaaaaaabcccccbbbbbdddddeeefffggghhhhhhhiiiiiiiiiiiiijjjjjjjjjjjjjjjj";
    }
}
