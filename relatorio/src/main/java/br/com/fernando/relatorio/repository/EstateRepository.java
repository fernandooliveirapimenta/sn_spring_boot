package br.com.fernando.relatorio.repository;

import br.com.fernando.relatorio.model.Estate;
import br.com.fernando.relatorio.model.ReportChartDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstateRepository extends CrudRepository<Estate, Long> {

    @Query(value = "select new br.com.fernando.relatorio.model.ReportChartDTO(e.id, e.cidades.size ,e.nome) from Estate e")
    List<ReportChartDTO> chartGenerate();
}
