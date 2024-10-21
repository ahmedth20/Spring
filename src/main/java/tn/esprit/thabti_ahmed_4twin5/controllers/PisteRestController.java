package tn.esprit.thabti_ahmed_4twin5.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.thabti_ahmed_4twin5.entities.Piste;
import tn.esprit.thabti_ahmed_4twin5.Services.PisteServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/piste")
public class PisteRestController {

    private final PisteServiceImpl pisteService;

    @PostMapping("/add")
    public Piste addPiste(@RequestBody Piste piste) {
        return pisteService.addPiste(piste);
    }

    @PutMapping("/update")
    public Piste updatePiste(@RequestBody Piste piste) {
        return pisteService.updatePiste(piste);
    }

    @GetMapping("/get/{numPiste}")
    public Piste getPiste(@PathVariable Long numPiste) {
        return pisteService.retrievePiste(numPiste);
    }

    @GetMapping("/all")
    public List<Piste> getAllPistes() {
        return pisteService.getAllPistes();
    }

    @DeleteMapping("/delete/{numPiste}")
    public void deletePiste(@PathVariable Long numPiste) {
        pisteService.removePiste(numPiste);
    }
}
