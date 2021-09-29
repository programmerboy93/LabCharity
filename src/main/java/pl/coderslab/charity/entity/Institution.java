package pl.coderslab.charity.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Table(name = "institutions")
public class Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(length = 40)
    @Size(max = 40)
    private String name;

    @NotEmpty
    @Column(length = 500)
    @Size(min = 10, max = 500)
    private String description;

//    name : Fundacja “Bez domu”
//    description : Cel i misja: Pomoc dla osób nie posiadających miejsca zamieszkania
}
