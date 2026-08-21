package ir.maktabsharif.model;

//Game
//id
//title
//description
//price

import jakarta.persistence.*;
import org.hibernate.annotations.Check;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "games")
public class Game extends BaseModel<Long> {

    @Column(nullable = false,unique = true)
    private String title;

    @Lob
    private String description;

    @Check(constraints = "price > 0")
    private BigDecimal price;

    // game 1 => 2
    @ManyToOne(
            cascade = CascadeType.PERSIST
    )
    private Developer developer;
    @OneToMany(mappedBy = "game", cascade = {CascadeType.PERSIST,CascadeType.REMOVE},orphanRemoval = true)
    private List<Edition> editions;

    public List<Edition> getEditions() {
        return editions;
    }

    public void setEditions(List<Edition> editions) {
        this.editions = editions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }
}

