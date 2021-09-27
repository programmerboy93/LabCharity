package pl.coderslab.charity.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Table(name="institutions")
public class Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Column(length = 500)
    @Size(min = 3, max = 500)
    private String name;

    @NotEmpty
    @Length(min=10,max=500)
    private String description;

//    name : Fundacja “Bez domu”
//    description : Cel i misja: Pomoc dla osób nie posiadających miejsca zamieszkania
}
