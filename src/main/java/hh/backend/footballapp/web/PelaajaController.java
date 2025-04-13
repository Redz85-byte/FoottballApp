package hh.backend.footballapp.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.backend.footballapp.domain.Pelaaja;
import hh.backend.footballapp.repository.JoukkueRepository;
import hh.backend.footballapp.repository.PelaajaRepository;
import jakarta.validation.Valid;

@Controller
public class PelaajaController {

    private final PelaajaRepository pelaajaRepository;
    private final JoukkueRepository joukkueRepository;

    public PelaajaController(PelaajaRepository pelaajaRepository, JoukkueRepository joukkueRepository) {
        this.pelaajaRepository = pelaajaRepository;
        this.joukkueRepository = joukkueRepository;
    }

    @GetMapping("/pelaajalista")
    public String hankiKaikkkiPelaajat(Model model) {

        List<Pelaaja> joukkue1 = pelaajaRepository.findByJoukkueId(1);
        List<Pelaaja> joukkue2 = pelaajaRepository.findByJoukkueId(2);

        model.addAttribute("joukkue1", joukkue1);
        model.addAttribute("joukkue2", joukkue2);

        return "pelaajalista";
    }

    @GetMapping("/lisaapelaaja")
    public String lisaaPelaaja(Model model) {
        model.addAttribute("pelaaja", new Pelaaja());
        model.addAttribute("joukkueet", joukkueRepository.findAll());
        return "lisaapelaaja";
    }

    @PostMapping("/lisaapelaaja")
    public String addPlayer(@Valid @ModelAttribute Pelaaja pelaaja, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("joukkueet", joukkueRepository.findAll());
            return "lisaapelaaja";
        }

        pelaajaRepository.save(pelaaja);
        return "redirect:/pelaajalista";
    }

    @GetMapping("/muokkaapelaaja/{id}")
    public String editoipelaaja(@PathVariable("id") Long id, Model model) {
        Pelaaja pelaaja = pelaajaRepository.findById(id).orElse(null);

        if (pelaaja == null) {
            model.addAttribute("error", "Pelaajaa ei löydy");
            return "redirect:/pelaajalista";
        }

        model.addAttribute("pelaaja", pelaaja);
        model.addAttribute("joukkueet", joukkueRepository.findAll());
        return "muokkaapelaaja";
    }

    @PostMapping("/muokkaapelaaja/{id}")
    public String muokkaapelaajaa(@PathVariable("id") Long id, @Valid @ModelAttribute Pelaaja pelaaja,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("joukkueet", joukkueRepository.findAll());
            return "muokkaapelaaja";
        }

        pelaaja.setPelaajaId(id); // Asetetaan ID lomakkeen olioon jotta JPA tietää päivittää oikean pelaajan
        pelaajaRepository.save(pelaaja);

        return "redirect:/pelaajalista"; // Uudelleenohjaa pelaajalista-sivulle
    }

    @PostMapping("/delete/{id}")
    public String deletePelaaja(@PathVariable Long id) {
        pelaajaRepository.deleteById(id);
        return "redirect:/pelaajalista"; // Delete, jolla pystyy poistaa erinäköisiä tietoja
    }

}
