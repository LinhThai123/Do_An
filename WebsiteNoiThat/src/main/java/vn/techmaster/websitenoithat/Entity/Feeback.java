package vn.techmaster.websitenoithat.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Feeback")
@Table(name = "feeback")
public class Feeback implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id ;

    @Column (name = "fullname" )
    private String fullname ;

    @Column(name = "email")
    private String email ;

    @Column(name = "title" )
    private String title ;

    @Column(name = "content")
    private String content ;
}
