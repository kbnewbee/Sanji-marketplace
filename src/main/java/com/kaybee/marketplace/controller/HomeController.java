package com.kaybee.marketplace.controller;

import com.kaybee.marketplace.global.GlobalData;
import com.kaybee.marketplace.service.CategoryService;
import com.kaybee.marketplace.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "index";
    }

    @GetMapping("/shop")
    public String shop(Model model) {
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("products", productService.getAllProduct());
        model.addAttribute("cartCount", GlobalData.cart.size());

        return "shop";
    }

    @GetMapping("/shop/category/{id}")
    public String shopByCategory(@PathVariable int id, Model model) {
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("products", productService.getAllProductByCategoryid(id));
        model.addAttribute("cartCount", GlobalData.cart.size());

        return "shop";
    }

    @GetMapping("/shop/viewproduct/{id}")
    public String viewProduct(@PathVariable long id, Model model) {
        model.addAttribute("product", productService.getProductById(id).get());
        return "viewProduct";
    }

}
