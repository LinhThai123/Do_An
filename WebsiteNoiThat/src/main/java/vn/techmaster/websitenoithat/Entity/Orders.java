package vn.techmaster.websitenoithat.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Entity(name = "Orders")
@Table(name = "orders")
public class Orders implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    @Column(name = "email")
    private String email ;

    @Column(name = "phone" , length = 12)
    private String phone ;

    @Column (name = "address" )
    private String address ;

    @Column (name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date created_at ;

    @Column (name = "updated_at")
    @Temporal(TemporalType.DATE)
    private Date updated_at ;

    // Liên kết 1 order - n order_detail
    @OneToMany(mappedBy = "orders",cascade = CascadeType.ALL , orphanRemoval = true )
    @JsonManagedReference
    private List<Order_detail> order_details = new ArrayList<>();

    // Liên kết 1 cus - n orders
    @ManyToOne
    @JoinColumn(name = "customer_id" , nullable = false )
    @JsonBackReference
    private Customer customer;
}
