package ir.maktabsharif.model;

import jakarta.persistence.*;

import java.util.List;

//Developer
//id
//name
//country
@Entity
@Table(name = "developers")
public class Developer extends BaseModel<Long> {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String country;


    // 1 => many 1   2    3 // parent  // inverse
    @OneToMany(
            mappedBy = "developer",
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )
    private List<Game> games;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}

