package tn.esprit.thabti_ahmed_4twin5.Services;

import tn.esprit.thabti_ahmed_4twin5.Repositories.ISkieurRepository;
import tn.esprit.thabti_ahmed_4twin5.entities.Skieur;

public class SkierServicesimpl {
    private ISkieurRepository skieurRepository;
    public Skieur addSkier(Skieur skieur){
        return skieurRepository.save(skieur);
    }
}
