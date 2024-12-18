package tn.esprit.thabti_ahmed_4twin5.Services;

import tn.esprit.thabti_ahmed_4twin5.entities.Color;
import tn.esprit.thabti_ahmed_4twin5.entities.Piste;
import tn.esprit.thabti_ahmed_4twin5.entities.Skieur;

import java.util.List;

public interface IPisteService {
    Piste addPiste(Piste piste);
    Piste updatePiste(Piste piste);
    void removePiste(Long numPiste);
    Piste retrievePiste(Long numPiste);
    List<Piste> getAllPistes();

    Skieur assignSkieurToPiste(String fname, String lname, Color color);
}
