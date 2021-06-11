package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller

public class DictionaryController {
    Map<String,String> dictionary = new HashMap<>();
    @GetMapping("/dictionary")
    public ModelAndView translate(@RequestParam(required = false, name = "input") String value, Model model){
        dictionary.put("xin chao","hello");
        dictionary.put("cho","dog");
        dictionary.put("meo","cat");
        ModelAndView modelAndView = new ModelAndView("index");
        String result = null;
        if (dictionary.containsKey(value)){
          model.addAttribute("result",dictionary.get(value));
        }

        return modelAndView;
    }
}
