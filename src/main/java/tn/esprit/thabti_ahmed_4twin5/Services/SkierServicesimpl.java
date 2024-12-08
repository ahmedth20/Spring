package tn.esprit.thabti_ahmed_4twin5.Services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.thabti_ahmed_4twin5.Repositories.ICourseRepository;
import tn.esprit.thabti_ahmed_4twin5.Repositories.IPisteRepository;
import tn.esprit.thabti_ahmed_4twin5.Repositories.ISkieurRepository;
import tn.esprit.thabti_ahmed_4twin5.Repositories.ISubscriptionRepository;
import tn.esprit.thabti_ahmed_4twin5.entities.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;


@Service
@Slf4j
public class SkierServicesimpl implements ISkieurServices{
@Autowired
    private ISkieurRepository skieurRepository;
    @Autowired
    private final IPisteRepository pisteRepository;
    @Autowired
    private  ISubscriptionRepository subscriptionRepository;
    @Autowired
    private IRegistrationService registrationRepository;
    @Autowired
    private ICourseRepository courseRepository;


    public SkierServicesimpl(IPisteRepository pisteRepository, ISubscriptionRepository subscriptionRepository) {
        this.pisteRepository = pisteRepository;
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public Skieur addSkieur(Skieur skieur){
        Subscription subscription = skieur.getSubscription();
        subscriptionRepository.save(subscription);
        skieur.setSubscription(subscription);
        return skieurRepository.save(skieur);
    }


    @Override
    public Skieur updateSkieur(Skieur skieur){
        return skieurRepository.save(skieur);
    }

    @Override
    public Skieur retrieveSkieur(long numSkieur){
        return skieurRepository.findById(numSkieur).orElse(null);
    }
    @Override
    public List<Skieur> retriveAllSkieur(){
        return (List<Skieur>) skieurRepository.findAll();
    }
    @Override
    public void removeSkieur(long numSkieur){
        skieurRepository.deleteById(numSkieur);
    }
@Override
    public void assignSkierToPiste(Long numSkier, Long numPiste) {
        Skieur skieur = skieurRepository.findById(numSkier).orElse(null);
        Piste piste = pisteRepository.findById(numPiste).orElse(null);

        piste.getSkieurs().add(skieur);
        pisteRepository.save(piste);

    }

    @Override
    public Skieur findByFirstNameAndLastName(String firstName, String lastName) {
        return skieurRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public Skieur findByBirthdate(LocalDate birthDate) {
            return skieurRepository.findByBirthDate(birthDate); // Implémentez la méthode dans le repository

    }
    public Skieur addRegistrationAndAssignToSkieur(Registration registration, Long numSkieur) {

        Skieur skieur = skieurRepository.findById(numSkieur)
                .orElseThrow(() -> new RuntimeException("Skieur not found"));
        registration.setSkieur(skieur);
        registrationRepository.addRegistration(registration);
        skieur.getRegistrations().add(registration);
        return skieurRepository.save(skieur);
    }

    @Override
    public Skieur addSkierAndAssignToCourse(Skieur skieur, Long numCourse) {
        Subscription subscription = new Subscription();
        skieur.setSubscription(subscription);
        subscriptionRepository.save(subscription);

        Course course = courseRepository.findById(numCourse).orElseThrow(() ->
                new IllegalArgumentException("Course not found with ID: " + numCourse)
        );

        Registration registration = new Registration();
        registration.setCourse(course);
        registration.setSkieur(skieur);

        if (skieur.getRegistrations() == null) {
            skieur.setRegistrations(new HashSet<>());
        }

        skieur.getRegistrations().add(registration);
        registrationRepository.addRegistration(registration); // replace `addRegistration` with `save`
        return skieurRepository.save(skieur);
    }

    @Override
    public List<Skieur> retrieveSkiersBySubscriptionType(TypeSubscription typeSubscription) {
        return skieurRepository.findBySubscription_TypeSub(typeSubscription);
    }

    @Scheduled(cron = "*/15 * * * * *")
    @Override
    public void listeSkieurAbonnesTerminerNotif() {
        // System.out.println("Bonjour");
        log.info("bonjour");
        log.debug("in methode : getSkiersNotif");
        log.error("ceci est une exception");
        log.warn("Warning ");
    }


}
