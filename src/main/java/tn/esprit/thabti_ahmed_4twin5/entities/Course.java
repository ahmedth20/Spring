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
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@ToString
@Table
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long numCourse ;
    private int level ;
    private Float price ;
    private int timeSlot ;
    @Enumerated(EnumType.STRING)
    private Support support;
    public enum Support {
        SKI, SNOWBOARD
    }

    @Enumerated(EnumType.STRING)
    private TypeCourse typeCourse;
    @JsonIgnore
    @OneToMany(mappedBy = "course")
    Set<Registration> registrations;

}
