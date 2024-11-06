package tn.esprit.thabti_ahmed_4twin5.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@ToString
@Table
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Registration implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long numRegistraion ;
    private int numWeek ;
    @JsonIgnore
    @ManyToOne
    Skieur skieur;

    @ManyToOne
    Course course;

}
