package com.kaikeba.webflux.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class SomeController {

    @GetMapping("/common")
    public String commonHandle() {
        log.info("common--start");
        // 执行一个耗时操作
        String result = doSome("common handler");
        log.info("common--end");
        return result;
    }

    @GetMapping("/mono")
    public Mono<String> monoHandle() {
        log.info("mono--start");
        // 执行耗时操作
        Mono<String> mono = Mono.fromSupplier(() -> doSome("mono handler"));
        log.info("mono--end");
        // Mono表示包含0或1个元素的异步序列
        return mono;
    }

    @RequestMapping("/flux")
    public Flux<String> fluxHandle() {
        // Flux表示包含0或n个元素的异步序列
        return Flux.just("beijing", "shanghai", "guangzhou");
    }

    @RequestMapping("/array")
    public Flux<String> fluxHandle(@RequestParam String[] cities) {
        // 将数组转换为Flux
        return Flux.fromArray(cities);
    }

    @RequestMapping("/list")
    public Flux<String> fluxHandle(@RequestParam List<String> cities) {
        // 将List转为Stream，再将Stream转为Flux
        return Flux.fromStream(cities.stream());
    }

    @RequestMapping("/time")
    public Flux<String> timeHandle(@RequestParam List<String> cities) {
        log.info("flux--start");
        // 将Flux的每个元素映射为一个doSome()耗时操作
        Flux<String> flux = Flux.fromStream(cities.stream().map(i -> doSome("elem-" + i)));
        log.info("flux--start");
        return flux;
    }

    @RequestMapping(value = "/sse", produces = "text/event-stream")
    public Flux<String> sseHandle() {
        // Flux表示包含0或n个元素的异步序列
        return Flux.just("beijing", "shanghai", "guangzhou");
    }



    // 定义耗时操作
    private String doSome(String msg) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return msg;
    }

}
