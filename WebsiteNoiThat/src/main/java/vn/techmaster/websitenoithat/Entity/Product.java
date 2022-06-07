package vn.techmaster.websitenoithat.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Product")
@Table(name = "Product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    @Column (name = "name" , columnDefinition = "nvarchar(100) not null")
    private String name ;

    @Column (name = "quantity" )
    private int quantity ;

    @Column(name = "price")
    private double price ;

    @Column (name = "image" , length = 200)
    private String image ;

    @Column (name = "description" , columnDefinition = "nvarchar(500)")
    private String description ;

    @Column (name = "discount")
    private double discount ;

    @Column (name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date created_at ;

    @Column (name = "update_at")
    @Temporal(TemporalType.DATE)
    private Date update_at ;

    @Column (name = "state" )
    @Enumerated
    private Status status ;

    //Liên kết category 1 - n product
    @ManyToOne
    @JoinColumn(name = "category_id" , nullable = false )
    @JsonBackReference
    private Category category;

    // Liên kết 1 product - n galery
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL , orphanRemoval = true )
    @JsonManagedReference
    private List<Galery> galeries = new ArrayList<>();


    // Liên kết 1 product - n order_detail
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL , orphanRemoval = true )
    @JsonManagedReference
    private List<Order_detail> order_details = new ArrayList<>();


}

