package com.mg.gifdemo.controller;


import com.mg.gifdemo.repository.GifRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GitController {

    @ResponseBody
    @GetMapping("/test")
    public String listGifs(){
        return GifRepository.getAllGifs().toString();
    }

}
