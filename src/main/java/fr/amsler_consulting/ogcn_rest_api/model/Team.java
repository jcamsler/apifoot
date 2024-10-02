package fr.amsler_consulting.ogcn_rest_api.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String acronym;

    @Column(nullable = false)
    private Double budget;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "team")
    private Set<Player> players;

    public Team() {
    }

    public Team(Long id, String name, String acronym, Double budget, Set<Player> players) {
        this.id = id;
        this.name = name;
        this.acronym = acronym;
        this.budget = budget;
        this.players = players;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcronym() {
        return this.acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public Double getBudget() {
        return this.budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public Set<Player> getPlayers() {
        return this.players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}
