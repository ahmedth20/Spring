package tn.esprit.thabti_ahmed_4twin5.Services;

import tn.esprit.thabti_ahmed_4twin5.entities.Registration;
import java.util.List;

public interface IRegistrationService {
    Registration addRegistration(Registration registration);
    Registration updateRegistration(Registration registration);
    void removeRegistration(Long numRegistration);
    Registration retrieveRegistration(Long numRegistration);
    List<Registration> getAllRegistrations();
}
