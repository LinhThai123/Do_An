package vn.techmaster.websitenoithat.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Galery")
@Table (name = "Galery")
public class Galery implements Serializable {

    @Id @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id ;

    @Column(name = "thumbnail" , columnDefinition = "varchar(500)")
    private String thumbnail ;

    // Liên kết 1 product - n galery
    @ManyToOne
    @JoinColumn(name = "product_id" , nullable = false )
    @JsonBackReference
    private Product product;
}
