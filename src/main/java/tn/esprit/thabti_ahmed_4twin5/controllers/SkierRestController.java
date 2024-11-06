package tn.esprit.thabti_ahmed_4twin5.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.thabti_ahmed_4twin5.Services.ISkieurServices;
import tn.esprit.thabti_ahmed_4twin5.Services.SkierServicesimpl;
import tn.esprit.thabti_ahmed_4twin5.entities.Registration;
import tn.esprit.thabti_ahmed_4twin5.entities.Skieur;
import tn.esprit.thabti_ahmed_4twin5.Repositories.ISkieurRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("skieur")
public class SkierRestController {

   private final ISkieurServices skierServices;

   @PostMapping("/add")
    public Skieur addSkieur(@RequestBody Skieur skieur) {
       return skierServices.addSkieur(skieur);
   }
    @PutMapping("/update")
    public Skieur updateSkieur(@RequestBody Skieur skieur) {
        return skierServices.updateSkieur(skieur);
    }
    @GetMapping("/get/{numSkier}")
    public Skieur getSkier(@PathVariable Long numSkier){
        return skierServices.retrieveSkieur(numSkier);
    }
    @GetMapping("/all")
    public List<Skieur> getAllSkieurs() {
        return skierServices.retriveAllSkieur();
    }
    @DeleteMapping("/delete/{numSkier}")
    public void deleteSkieur(@PathVariable Long numSkier) {
        skierServices.removeSkieur(numSkier);
    }
    @PutMapping("/add/{numSkier}/{numPiste}")
    public void assignSkierToPiste(@PathVariable Long numSkier, @PathVariable Long numPiste) {
        skierServices.assignSkierToPiste(numSkier, numPiste);
    }
    @GetMapping ("/getBy/{fname}/{lname}")
    public Skieur getSkieurByFname(@PathVariable String fname, @PathVariable String lname) {
       return skierServices.findByFirstNameAndLastName(fname,lname);
    }
    @GetMapping("/getByBirthdate/{birthDate}")
    public Skieur getSkieurByBirthdate(@PathVariable LocalDate birthDate) {
        return skierServices.findByBirthdate(birthDate);
    }

    @PostMapping("/addRegistration/{numSkieur}")
    public Skieur addRegistrationAndAssignToSkieur(@RequestBody Registration registration, @PathVariable Long numSkieur) {
        return skierServices.addRegistrationAndAssignToSkieur(registration, numSkieur);
    }

}
