package tn.esprit.thabti_ahmed_4twin5.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.thabti_ahmed_4twin5.Repositories.ISkieurRepository;
import tn.esprit.thabti_ahmed_4twin5.entities.Skieur;

import java.util.List;


@Service
public class SkierServicesimpl implements ISkieurServices{
@Autowired
    private ISkieurRepository skieurRepository;

    @Override
    public Skieur addSkieur(Skieur skieur){
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
}
