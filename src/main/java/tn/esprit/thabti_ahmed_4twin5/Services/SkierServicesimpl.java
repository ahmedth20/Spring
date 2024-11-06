package tn.esprit.thabti_ahmed_4twin5.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.thabti_ahmed_4twin5.Repositories.IPisteRepository;
import tn.esprit.thabti_ahmed_4twin5.Repositories.ISkieurRepository;
import tn.esprit.thabti_ahmed_4twin5.Repositories.ISubscriptionRepository;
import tn.esprit.thabti_ahmed_4twin5.entities.Piste;
import tn.esprit.thabti_ahmed_4twin5.entities.Registration;
import tn.esprit.thabti_ahmed_4twin5.entities.Skieur;
import tn.esprit.thabti_ahmed_4twin5.entities.Subscription;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Service
public class SkierServicesimpl implements ISkieurServices{
@Autowired
    private ISkieurRepository skieurRepository;
    @Autowired
    private final IPisteRepository pisteRepository;
    @Autowired
    private  ISubscriptionRepository subscriptionRepository;
    @Autowired
    private IRegistrationService registrationRepository;


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

}
