package tn.esprit.thabti_ahmed_4twin5.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.thabti_ahmed_4twin5.Services.IRegistrationService;
import tn.esprit.thabti_ahmed_4twin5.entities.Registration;

import java.util.List;

@RestController
@Tag(name = "Gestion Registration")
@RequiredArgsConstructor
@RequestMapping("/registration")
public class RegistrationRestController {

    private final IRegistrationService registrationService;

    @PostMapping("/add")
    public Registration addRegistration(@RequestBody Registration registration) {
        return registrationService.addRegistration(registration);
    }

    @PutMapping("/update")
    public Registration updateRegistration(@RequestBody Registration registration) {
        return registrationService.updateRegistration(registration);
    }

    @GetMapping("/get/{numRegistration}")
    public Registration getRegistration(@PathVariable Long numRegistration) {
        return registrationService.retrieveRegistration(numRegistration);
    }

    @GetMapping("/all")
    public List<Registration> getAllRegistrations() {
        return registrationService.getAllRegistrations();
    }

    @DeleteMapping("/delete/{numRegistration}")
    public void deleteRegistration(@PathVariable Long numRegistration) {
        registrationService.removeRegistration(numRegistration);
    }
    @PostMapping("/assignToCourse/{numCourse}")
    public Registration assignRegistrationToCourse(@RequestBody Registration registration, @PathVariable Long numCourse ) {
        return registrationService.addRegistartionToCourse(registration, numCourse);
    }
}
