package hh.backend.footballapp.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.backend.footballapp.domain.Ottelu;
import hh.backend.footballapp.repository.JoukkueRepository;
import hh.backend.footballapp.repository.OtteluRepository;
import jakarta.validation.Valid;

@Controller
public class OtteluController {

    private final OtteluRepository otteluRepository;
    private final JoukkueRepository joukkueRepository;

    public OtteluController(OtteluRepository otteluRepository, JoukkueRepository joukkueRepository) {
        this.otteluRepository = otteluRepository;
        this.joukkueRepository = joukkueRepository;
    }

    @GetMapping("/ottelut1")
    public String naytaOttelut2011(Model model) {
        List<Ottelu> ottelut2011 = otteluRepository.findByJoukkueId(1L);
        model.addAttribute("ottelut2011", ottelut2011);
        return "ottelulista2011";
    }

    @GetMapping("/ottelut2")
    public String naytaOttelut2015(Model model) {
        List<Ottelu> ottelut2015 = otteluRepository.findByJoukkueId(2L);
        model.addAttribute("ottelut2015", ottelut2015);
        return "ottelulista2015";
    }

    @GetMapping("/lisaaottelu")
    public String lisataanOttelu(Model model) {
        model.addAttribute("ottelu", new Ottelu());
        model.addAttribute("joukkueet", joukkueRepository.findAll());
        return "lisaaottelu";
    }

    @PostMapping("/lisaaottelu")
    public String tallennaOttelu(@Valid @ModelAttribute Ottelu ottelu, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("joukkueet", joukkueRepository.findAll());
            return "lisaaottelu";
        }
    
        Long joukkueId = ottelu.getJoukkue().getId();
        otteluRepository.save(ottelu);
    
        if (joukkueId == 1L) {
            return "redirect:/ottelut1";
        } else {
            return "redirect:/ottelut2";
        }
    }
    @GetMapping("/muokkaaottelu/{id}")
    public String muokkaaOttelu(@PathVariable Long id, Model model) {
        Ottelu ottelu = otteluRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Virheellinen ottelu ID: " + id));
        model.addAttribute("ottelu", ottelu);
        model.addAttribute("joukkueet", joukkueRepository.findAll());
        return "muokkaaottelu";
    }

    @PostMapping("/muokkaaottelu/{id}")
    public String tallennaMuokattuOttelu(@PathVariable Long id, @Valid @ModelAttribute Ottelu ottelu,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("joukkueet", joukkueRepository.findAll());
            return "muokkaaottelu";
        }

        ottelu.setOtteluId(id);
        otteluRepository.save(ottelu);
       
        
        Long joukkueId = ottelu.getJoukkue().getId();

        if (joukkueId == 1L) {
            return "redirect:/ottelut1";
        } else {
            return "redirect:/ottelut2";
        }
    }


    @PostMapping("/poistaottelu/{id}")
    public String poistaOttelu(@PathVariable Long id) {
        Ottelu ottelu = otteluRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Virheellinen ottelu ID: " + id));

        Long joukkueId = ottelu.getJoukkue().getId();

        otteluRepository.delete(ottelu);

        if (joukkueId == 1L) {
            return "redirect:/ottelut1";
        } else {
            return "redirect:/ottelut2";
        }
    }
}
