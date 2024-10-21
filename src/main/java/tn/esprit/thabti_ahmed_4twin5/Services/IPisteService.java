package tn.esprit.thabti_ahmed_4twin5.Services;

import tn.esprit.thabti_ahmed_4twin5.entities.Piste;
import java.util.List;

public interface IPisteService {
    Piste addPiste(Piste piste);
    Piste updatePiste(Piste piste);
    void removePiste(Long numPiste);
    Piste retrievePiste(Long numPiste);
    List<Piste> getAllPistes();
}
