package br.com.fernando.relatorio.controller;

import br.com.fernando.relatorio.repository.CityRepository;
import br.com.fernando.relatorio.service.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reports")
public class ReportController {

    private final EstateService estateService;
    private final CityRepository cityRepository;

    @Autowired
    public ReportController(EstateService estateService, CityRepository cityRepository) {
        this.estateService = estateService;
        this.cityRepository = cityRepository;
    }

    @GetMapping("/html")
    public String html(@RequestParam(value = "estate", required = false) Long id,
                                   Model model) {
        model.addAttribute("estates", estateService.listar());
        if(id == null) {
            return "report/index";
        }

        model.addAttribute("cities", cityRepository.findByEstate_Id(id));

        return "report/index";


    }
}
