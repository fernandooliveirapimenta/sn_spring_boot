package br.com.fernando.sb1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/animal")
public class AnimalController {

    @GetMapping
    @ResponseBody
    public String hello() {
        return "Animal controller";
    }
}
