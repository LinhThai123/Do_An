package vn.techmaster.websitenoithat.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Category")
@Table(name = "category")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    @Column (name = "name" )
    private String name ;

    @Column (name = "code" )
    private String code ;

    // Liên kết 1 categpoy - n product
    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL , orphanRemoval = true )
    @JsonManagedReference
    private List<Product> products = new ArrayList<>();
}