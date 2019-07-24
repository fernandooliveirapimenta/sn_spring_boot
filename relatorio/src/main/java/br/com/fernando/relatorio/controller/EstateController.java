package br.com.fernando.relatorio.controller;

import br.com.fernando.relatorio.model.Estate;
import br.com.fernando.relatorio.service.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/estates")
public class EstateController {

    private final EstateService estateService;

    @Autowired
    public EstateController(EstateService estateService) {
        this.estateService = estateService;
    }

    @GetMapping
    public Iterable<Estate> listar(){
        return estateService.listar();
    }

    @PostMapping
    public Estate criar(@RequestBody Estate estate) {
        return estateService.create(estate);
    }

}
