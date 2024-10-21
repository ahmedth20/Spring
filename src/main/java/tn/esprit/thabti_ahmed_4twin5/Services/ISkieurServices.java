package tn.esprit.thabti_ahmed_4twin5.Services;

import tn.esprit.thabti_ahmed_4twin5.entities.Skieur;

import java.util.List;

public interface ISkieurServices {
    Skieur addSkieur(Skieur skieur);
    Skieur updateSkieur(Skieur skieur);

    Skieur retrieveSkieur(long numSkieur);
    List<Skieur> retriveAllSkieur();
    void removeSkieur(long numSkieur);


}
