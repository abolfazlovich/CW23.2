package ir.maktabsharif.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.annotations.Check;

import java.math.BigDecimal;

//User
//id
//username
//email
//balance
@Entity
@Table(name = "users")
public class User extends BaseModel<Long> {

    @Column(unique = true,nullable = false)
    private String username;
    @Column(unique = true,nullable = false)
    private String email;
    @Check(constraints = "balance > 0")
    private BigDecimal balance;




}

