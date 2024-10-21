package tn.esprit.thabti_ahmed_4twin5.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.thabti_ahmed_4twin5.entities.Piste;
import tn.esprit.thabti_ahmed_4twin5.Repositories.IPisteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PisteServiceImpl implements IPisteService {

    private final IPisteRepository pisteRepository;

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
}
