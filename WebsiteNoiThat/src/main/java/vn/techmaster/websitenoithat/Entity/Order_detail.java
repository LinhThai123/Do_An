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
@Entity(name = "Order_detail")
@Table(name = "order_detail")
public class Order_detail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    @Column(name = "price")
    private double price ;

    @Column(name = "quantity")
    private int quantity ;

    @Column (name = "discount")
    private double discount ;

    //TODO Liên kết với bảng product
    @ManyToOne
    @JoinColumn(name = "product_id" , nullable = false )
    @JsonBackReference
    private Product product;

    //TODO liên kết với bảng order
    @ManyToOne
    @JoinColumn(name = "order_id" , nullable = false )
    @JsonBackReference
    private Orders orders;
}
