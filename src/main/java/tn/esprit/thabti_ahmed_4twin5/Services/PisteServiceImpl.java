package tn.esprit.thabti_ahmed_4twin5.Services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.thabti_ahmed_4twin5.entities.Color;
import tn.esprit.thabti_ahmed_4twin5.entities.Piste;
import tn.esprit.thabti_ahmed_4twin5.Repositories.IPisteRepository;
import tn.esprit.thabti_ahmed_4twin5.entities.Skieur;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class PisteServiceImpl implements IPisteService {

    private final IPisteRepository pisteRepository;
    private final ISkieurServices skieurRepository;

    @Override
    public Piste addPiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public Piste updatePiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public void removePiste(Long numPiste) {
        pisteRepository.deleteById(numPiste);
    }

    @Override
    public Piste retrievePiste(Long numPiste) {
        return pisteRepository.findById(numPiste).orElse(null);
    }

    @Override
    public List<Piste> getAllPistes() {
        return (List<Piste>) pisteRepository.findAll();
    }

    @Override
    public Skieur assignSkieurToPiste(String fname, String lname, Color color) { //Les bonnes pratique est d'implementer
        //DANS LE PARENT

        Skieur skieur = skieurRepository.findByFirstNameAndLastName(fname, lname);
        if (skieur == null) {
            throw new IllegalArgumentException("Skieur non trouvé");
        }


        List<Piste> pistes = pisteRepository.findAllByColor(color);
        if (pistes.isEmpty()) {
            throw new IllegalArgumentException("Aucune piste trouvée avec la couleur " + color);
        }


        for (Piste piste : pistes) {
            Set<Skieur> skieurs = piste.getSkieurs();
            if (skieurs == null) {
                skieurs = new HashSet<>();
            }
            skieurs.add(skieur);
            piste.setSkieurs(skieurs);


            skieur.getPistes().add(piste);
            pisteRepository.save(piste);
        }


        return skieurRepository.addSkieur(skieur);
    }



}