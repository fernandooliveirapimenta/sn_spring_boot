package br.com.fernando.relatorio.model;

import java.io.Serializable;

public class ReportChartDTO implements Serializable {

    private Long id;
    private String name;
    private Long total;

    public ReportChartDTO() {

    }

    public ReportChartDTO(Long id, int total, String name) {
        this.id = id;
        this.name = name;
        this.total = (long) total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
