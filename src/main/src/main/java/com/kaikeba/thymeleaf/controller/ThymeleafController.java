package com.kaikeba.thymeleaf.controller;

import com.kaikeba.thymeleaf.StudentVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * company: www.kaikeba.com
 * Author: Rey
 */
@Controller
public class ThymeleafController {
    @RequestMapping("/some")
    public String indexHandle(Model model) {
        model.addAttribute("hello", "Hello Thymeleaf World");
        model.addAttribute("student", new StudentVO("张三", 23));

        return "index";
    }
}
