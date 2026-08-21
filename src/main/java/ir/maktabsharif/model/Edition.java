package ir.maktabsharif.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.DialectOverride;

import java.math.BigDecimal;

//Edition
//id
//name
//price
@Entity
@Table(name = "Editions")
public class Edition extends BaseModel<Long> {

    private String name;

    @Check(constraints = "price > 0")
    private BigDecimal price;
    @ManyToOne
    private Game game;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}

