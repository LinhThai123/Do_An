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
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Customer")
@Table(name = "Customer")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    @Column (name = "name" , nullable = false , columnDefinition = "nvarchar(50) not null")
    private String name ;

    @Column (name = "email" , nullable = false , columnDefinition = "nvarchar(100) not null")
    private String email ;

    @Column(name = "password" , nullable = false , length = 20)
    private String password ;

    @Column (name = "phone" , length = 12)
    private String phone ;

    @Column (name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date created_at ;

    @Column (name = "updated_at")
    @Temporal(TemporalType.DATE)
    private Date updated_at ;

    @Column (name = "state")
    @Enumerated
    private State state ;

    // Liên kết 1 cus - n order
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL , orphanRemoval = true )
    @JsonManagedReference
    private List<Orders> orders = new ArrayList<>();

    //TODO liên kết với bảng role 1 - n customer
    @ManyToOne
    @JoinColumn(name = "role_id" , nullable = false )
    @JsonBackReference
    private Role role;

}
