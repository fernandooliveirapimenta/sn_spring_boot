package com.fernando.sb2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/jogador")
public class JogadorController {

    @GetMapping
    public String hello() {
        return "hello";
    }
}
