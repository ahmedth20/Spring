package tn.esprit.thabti_ahmed_4twin5.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.thabti_ahmed_4twin5.Services.ISkieurServices;
import tn.esprit.thabti_ahmed_4twin5.entities.Color;
import tn.esprit.thabti_ahmed_4twin5.entities.Piste;
import tn.esprit.thabti_ahmed_4twin5.Services.PisteServiceImpl;
import tn.esprit.thabti_ahmed_4twin5.entities.Skieur;

import java.util.List;

@RestController
@Tag(name = "Gestion Piste")
@RequiredArgsConstructor
@RequestMapping("/piste")
public class PisteRestController {
    @Autowired
    private final PisteServiceImpl pisteService;

    @Autowired
    private ISkieurServices skieurServices;

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

    @PostMapping("/assignToPiste/{fname}/{lname}/{color}")
    public Skieur assignSkieurToPiste(@PathVariable String fname, @PathVariable String lname, @PathVariable Color color) {
        return pisteService.assignSkieurToPiste(fname, lname, color);
    }
}
