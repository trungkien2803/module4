package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ConversionController {
    @GetMapping("/conversion")
    public String conversionController(@RequestParam(defaultValue = "0",name = "vnd") String value, Model model){
        int result = Integer.parseInt(value) / 23000;
        model.addAttribute("result",result);
        return "index";
    }

}
