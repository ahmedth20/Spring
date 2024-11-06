package tn.esprit.thabti_ahmed_4twin5.Services;

import tn.esprit.thabti_ahmed_4twin5.entities.Registration;
import tn.esprit.thabti_ahmed_4twin5.entities.Skieur;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ISkieurServices {
    Skieur addSkieur(Skieur skieur);
    Skieur updateSkieur(Skieur skieur);

    Skieur retrieveSkieur(long numSkieur);
    List<Skieur> retriveAllSkieur();
    void removeSkieur(long numSkieur);
    void assignSkierToPiste(Long numSkier, Long numPiste);
    Skieur findByFirstNameAndLastName(String firstName, String lastName);
    Skieur findByBirthdate(LocalDate birthDate);
    Skieur addRegistrationAndAssignToSkieur(Registration registration, Long numSkieur);
}
