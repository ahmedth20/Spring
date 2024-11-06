package tn.esprit.thabti_ahmed_4twin5.Repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.thabti_ahmed_4twin5.entities.Skieur;

import java.time.LocalDate;
import java.util.Date;

public interface ISkieurRepository extends CrudRepository <Skieur, Long> {
   Skieur findByFirstNameAndLastName(String firstName, String lastName);
    Skieur findByBirthDate (LocalDate birthDate);
}
