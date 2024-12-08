package tn.esprit.thabti_ahmed_4twin5.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table//(name="t_skier")
public class Skieur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idskier;
    private String firstName;
    private String lastName;

    private LocalDate birthDate;
    private String city;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    Subscription subscription;

    @OneToMany(mappedBy = "skieur") ////Le child est l association la plus faible
    Set<Registration> registrations;

    @ManyToMany(mappedBy = "skieurs")  //MAPPED BY TOUJOURS DANS LE CHILD , on a le choix dans Parent et child dans les tables
    Set<Piste> pistes;

}
