package tn.esprit.thabti_ahmed_4twin5.Services;

import org.springframework.scheduling.annotation.Scheduled;
import tn.esprit.thabti_ahmed_4twin5.entities.Registration;
import tn.esprit.thabti_ahmed_4twin5.entities.Skieur;
import tn.esprit.thabti_ahmed_4twin5.entities.TypeSubscription;

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
    Skieur addSkierAndAssignToCourse(Skieur skieur, Long numCourse);
    List<Skieur> retrieveSkiersBySubscriptionType(TypeSubscription typeSubscription);

    @Scheduled(cron ="*/15 * * * * *")
    void listeSkieurAbonnesTerminerNotif();
}
