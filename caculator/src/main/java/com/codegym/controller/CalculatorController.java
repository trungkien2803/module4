package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {
    @GetMapping("/calculator")
    public ModelAndView calculator( String number1, String number2, String calculator,ModelAndView modelAndView,Model model) {
        if (calculator == null){
            calculator = "";
        }
        modelAndView = new ModelAndView("index");
        Double result = 0.0;
        if (calculator.equals("+")) {
            result = Double.parseDouble(number1) + Double.parseDouble(number2);
        } else if (calculator.equals("-")) {
            result = Double.parseDouble(number1) - Double.parseDouble(number2);
        } else if (calculator.equals("*")) {
            result = Double.parseDouble(number1) * Double.parseDouble(number2);
        } else if (calculator.equals("/")) {
            result = Double.parseDouble(number1) / Double.parseDouble(number2);
        } else {

        }
        model.addAttribute("result", result);
        return modelAndView;
    }
}
