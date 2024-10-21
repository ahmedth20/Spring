package tn.esprit.thabti_ahmed_4twin5.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.thabti_ahmed_4twin5.Services.SkierServicesimpl;
import tn.esprit.thabti_ahmed_4twin5.entities.Skieur;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("skieur")
public class SkierRestController {

   private final SkierServicesimpl skierServices;

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
}
