package br.com.fernando.relatorio.model;

import javax.persistence.*;

@Entity
@Table
public class Fork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String gold;

    @Column
    private String gold2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGold() {
        return gold;
    }

    public void setGold(String gold) {
        this.gold = gold;
    }

    public String getGold2() {
        return gold2;
    }

    public void setGold2(String gold2) {
        this.gold2 = gold2;
    }
}
