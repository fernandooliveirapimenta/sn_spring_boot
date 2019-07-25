package br.com.fernando.relatorio.service;

import br.com.fernando.relatorio.model.Estate;
import br.com.fernando.relatorio.model.ReportChartDTO;
import br.com.fernando.relatorio.repository.EstateRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstateService {

    private final EstateRepository estateRepository;

    public EstateService(EstateRepository estateRepository) {
        this.estateRepository = estateRepository;
    }

    public Estate create(Estate estate) {
        return this.estateRepository.save(estate);
    }

    public List<ReportChartDTO> chart() {
        return  estateRepository.chartGenerate();
    }

    @Transactional
    public Iterable<Estate> listar() {
        final Iterable<Estate> all = estateRepository.findAll();
        all.forEach(e -> e.getCidades().size());
        return all;
    }
}
