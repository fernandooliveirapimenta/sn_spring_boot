package br.com.fernando.relatorio.repository;

import br.com.fernando.relatorio.model.City;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CityRepository extends CrudRepository<City, Long> {

    List<City> findByEstate_Id(Long idEstado);
}
