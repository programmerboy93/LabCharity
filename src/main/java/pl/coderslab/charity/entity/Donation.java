package pl.coderslab.charity.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="donations")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Integer quantity;

    @OneToMany
    private List<Category> categories;

    @OneToMany
    private List<Institution> institutions;

    private String street;

    @NotEmpty
    private String city;

    @NotEmpty
    private String zipCode;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotEmpty
    private LocalDate pickUpDate;

    @NotEmpty
    private LocalTime pickUpTime;

    private String pickUpComment;
}
