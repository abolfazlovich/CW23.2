package ir.maktabsharif.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

//Category
//id
//name
@Entity
@Table(name = "categorys")
public class Category extends BaseModel<Long> {

    @Column(unique = true,nullable = false)
    private String name;

}
