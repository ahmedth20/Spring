package tn.esprit.thabti_ahmed_4twin5.Repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.thabti_ahmed_4twin5.entities.Color;
import tn.esprit.thabti_ahmed_4twin5.entities.Piste;

import java.util.List;

public interface IPisteRepository extends CrudRepository<Piste, Long> {
    List<Piste> findAllByColor(Color color);
}
