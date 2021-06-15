package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    ProductService productService = new ProductService();
    @GetMapping("")
    public ModelAndView showList(String search,Model model){
        List<Product> products;
        if (search == null || search.equals("")){
            products = productService.findAll();
        } else {
            products = productService.findByName(search);
        }
        ModelAndView modelAndView = new ModelAndView("index");

        model.addAttribute("products",products);
        return modelAndView;
    }

    @GetMapping("create")
    public ModelAndView create(Model model){
        ModelAndView modelAndView = new ModelAndView("create");
        model.addAttribute("product",new Product());
        return modelAndView;
    }
    @PostMapping("save")
    public ModelAndView save(Product product){
        ModelAndView modelAndView = new ModelAndView("redirect:/product");
        productService.save(product);
        return modelAndView;
    }
    @GetMapping("/{id}/delete")
    public ModelAndView remove(@PathVariable int id, Model model) {
        ModelAndView modelAndView = new ModelAndView("delete");
        model.addAttribute("product",productService.findById(id));
        return modelAndView;
    }
    @PostMapping("/delete")
    public ModelAndView delete(Product product, Model model) {
        ModelAndView modelAndView = new ModelAndView("redirect:/product");
        productService.remove(product.getId());
        return modelAndView;
    }
    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable int id, Model model) {
        ModelAndView modelAndView = new ModelAndView("edit");
        model.addAttribute("product",productService.findById(id));
        return modelAndView;
    }
    @PostMapping("/edit")
    public ModelAndView update(Product product, Model model) {
        ModelAndView modelAndView = new ModelAndView("redirect:/product");
        productService.update(product.getId(),product);
        return modelAndView;
    }
}
