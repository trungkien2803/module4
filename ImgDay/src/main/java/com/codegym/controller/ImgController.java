package com.codegym.controller;

import com.codegym.model.Img;
import com.codegym.service.IImgService;
import com.codegym.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ImgController {
    @Autowired
    IImgService imgService;

    @GetMapping("/img")
    public ModelAndView index(Model model){
        ModelAndView modelAndView = new ModelAndView("index");
        List<Img> imgs = imgService.findAll();
        model.addAttribute("imgs",imgs);
        return modelAndView;
    }
    @GetMapping("/comment")
    public ModelAndView comment(Model model) {
        ModelAndView modelAndView = new ModelAndView("comment");
        model.addAttribute("img",new Img());
        return modelAndView;
    }
    @PostMapping("/save")
    public String save(Img img) {
        imgService.save(img);
        return "redirect:/img";
    }
}
