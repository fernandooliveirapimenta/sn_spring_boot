package br.com.fernando.relatorio.controller;

import br.com.fernando.relatorio.model.City;
import br.com.fernando.relatorio.model.Estate;
import br.com.fernando.relatorio.model.ReportChartDTO;
import br.com.fernando.relatorio.repository.CityRepository;
import br.com.fernando.relatorio.service.EstateService;
import br.com.fernando.relatorio.service.PdfUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/chart")
    public String chat( Model model) {
        final List<ReportChartDTO> chart = estateService.chart();
        model.addAttribute("labels", chart.stream().map(ReportChartDTO::getName).collect(Collectors.toList()));
        model.addAttribute("data", chart.stream().map(ReportChartDTO::getTotal).collect(Collectors.toList()));
        return "report/chart";
    }

    @GetMapping("/pdf")
    public ResponseEntity<InputStreamResource> pdf(@RequestParam(value = "estate", required = false) Long id,
                                                   Model model) throws Exception {
        model.addAttribute("estates", estateService.listar());
        if(id == null) {
            return null;
        }
        final List<City> cities = cityRepository.findByEstate_Id(id);

        final ByteArrayInputStream byteArrayInputStream = PdfUtils.generatePdf(cities);

        return ResponseEntity
                . ok()
                .header("Content-Disposition",
                        "inline; filename=report.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(byteArrayInputStream));
    }

    @GetMapping("/csv")
    public void csv(HttpServletRequest request, HttpServletResponse response) throws IOException {

       response.setHeader("Content-Disposition",
               "attachment; filename-csv.csv");

       String[] header = {"id", "nome"};

        ICsvBeanWriter csvBeanWriter =
                new CsvBeanWriter(response.getWriter(),
                        CsvPreference.STANDARD_PREFERENCE);

        final Iterable<Estate> listar = estateService.listar();

        for (Estate estate : listar) {
            csvBeanWriter.write(estate, header);
        }

        csvBeanWriter.close();

    }
}
