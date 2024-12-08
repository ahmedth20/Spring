package tn.esprit.thabti_ahmed_4twin5.Services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.thabti_ahmed_4twin5.Repositories.ICourseRepository;
import tn.esprit.thabti_ahmed_4twin5.Repositories.ISkieurRepository;
import tn.esprit.thabti_ahmed_4twin5.entities.Course;
import tn.esprit.thabti_ahmed_4twin5.entities.Registration;
import tn.esprit.thabti_ahmed_4twin5.Repositories.IRegistrationRepository;
import tn.esprit.thabti_ahmed_4twin5.entities.Skieur;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RegistrationServiceImpl implements IRegistrationService {

    private final IRegistrationRepository registrationRepository;
    private final ICourseRepository courseRepository;
    private final ISkieurRepository skieurRepository;


    @Override
    public Registration addRegistration(Registration registration) {
        Skieur skieur = registration.getSkieur();
        if (skieur != null && skieur.getIdskier() == 0) { // Utiliser 0 pour vérifier un int non initialisé
            skieur = skieurRepository.save(skieur);
            registration.setSkieur(skieur);
        }
        return registrationRepository.save(registration);
    }


    @Override
    public Registration updateRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    @Override
    public void removeRegistration(Long numRegistration) {
        registrationRepository.deleteById(numRegistration);
    }

    @Override
    public Registration retrieveRegistration(Long numRegistration) {
        return registrationRepository.findById(numRegistration).orElse(null);
    }

    @Override
    public List<Registration> getAllRegistrations() {
        return (List<Registration>) registrationRepository.findAll();
    }
    @Override
    public Registration addRegistartionToCourse(Registration registration, Long numCourse)
    {
        Course course = courseRepository.findById(numCourse).orElse(null);
        registration.setCourse(course);
        return registrationRepository.save(registration);
    }

}
