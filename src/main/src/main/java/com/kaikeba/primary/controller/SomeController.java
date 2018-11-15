package com.kaikeba.primary.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * company: www.kaikeba.com
 * Author: Rey
 */
@RestController
public class SomeController {

    @GetMapping("/first/some")
    public String firstHandle() {
        return "first";
    }

    @GetMapping("/first/aaa")
    public String aaaHandle() {
        return "aaa";
    }
    @GetMapping("/second/other")
    public String secondHandle() {
        return "second";
    }
    @GetMapping("/third/xxx")
    public String thirdHandle() {
        return "third";
    }
}
