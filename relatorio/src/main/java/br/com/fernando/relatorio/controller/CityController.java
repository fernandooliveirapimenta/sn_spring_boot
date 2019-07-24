package br.com.fernando.relatorio.controller;

import br.com.fernando.relatorio.model.City;
import br.com.fernando.relatorio.model.Estate;
import br.com.fernando.relatorio.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/estates/{estateId}/cities")
public class CityController {

    private final CityRepository cityRepository;

    @Autowired
    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping
    public Iterable<City> listar(){
        return cityRepository.findAll();
    }

    @PostMapping
    public City criar(@PathVariable Long estateId, @RequestBody City city) {
        Estate e = new Estate();
        e.setId(estateId);
        city.setEstate(e);
        return cityRepository.save(city);
    }

}
