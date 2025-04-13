package hh.backend.footballapp.web;

import hh.backend.footballapp.domain.Ottelu;
import hh.backend.footballapp.repository.OtteluRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ottelut")
public class OtteluRestController {

    private final OtteluRepository otteluRepository;

    public OtteluRestController(OtteluRepository otteluRepository) {
        this.otteluRepository = otteluRepository;
    }

    @GetMapping
    public List<Ottelu> hankiKaikkiOttelut() {
        return (List<Ottelu>) otteluRepository.findAll();
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Ottelu> hankiOtteluIdlla(@PathVariable Long id) {
        Optional<Ottelu> ottelu = otteluRepository.findById(id);
        return ottelu.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

   
    @PostMapping
    public Ottelu tallennaOttelu(@RequestBody Ottelu ottelu) {
        return otteluRepository.save(ottelu);
    }
}
