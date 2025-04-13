package hh.backend.footballapp.web;

import hh.backend.footballapp.domain.Pelaaja;
import hh.backend.footballapp.repository.PelaajaRepository;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pelaajat")
public class PelaajaRestController {

    private final PelaajaRepository pelaajaRepository;

    public PelaajaRestController(PelaajaRepository pelaajaRepository) {
        this.pelaajaRepository = pelaajaRepository;
    }

 
    @GetMapping
    public List<Pelaaja> hankiKaikkiPelaajat() {
        return pelaajaRepository.findAll();
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Pelaaja> hankiPelaajatIdlla(@PathVariable Long id) {
        Optional<Pelaaja> pelaaja = pelaajaRepository.findById(id);
        return pelaaja.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    
    @PostMapping
    public Pelaaja tallennaOttelut(@Valid @RequestBody Pelaaja pelaaja, BindingResult result) {
        if (result.hasErrors()) {

         throw new IllegalArgumentException("Pelaaja on virheellinen.");
        }

        return pelaajaRepository.save(pelaaja);
    }
}
