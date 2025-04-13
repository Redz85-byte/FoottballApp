package hh.backend.footballapp.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
public class Ottelu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long otteluId;

   
    @NotNull(message = "Ottelutyyppi ei voi olla tyhjä")
    @Size(min = 5, message = "Ottelutyyppi on oltava vähintään 5 kirjainmerkkiä")
    private String ottelutyyppi;

    @NotNull(message = "Pvm ei voi olla tyhjä")
    private LocalDate pvm;

    @NotNull(message = "Vastustaja ei voi olla tyhjä")
    @Size(min = 3, message = "Vastustaja on oltava vähintään 3 kirjainmerkkiä")
    private String vastustaja;

    @Min(value = 0, message = "Ei voi olla negatiivinen luku")
    private int ppjmaalit;

    @Min(value = 0, message = "Ei voi olla negatiivinen luku")
    private int vastustajanmaalit;
   
    @ManyToOne
    @JoinColumn(name = "joukkue_id")
    private Joukkue joukkue; 

    public Ottelu() {
    }

    public Ottelu(Joukkue joukkue, String ottelutyyppi, LocalDate pvm, String vastustaja,
                  int ppjmaalit, int vastustajanmaalit) {
        this.joukkue = joukkue;
        this.ottelutyyppi = ottelutyyppi;
        this.pvm = pvm;
        this.vastustaja = vastustaja;
        this.ppjmaalit = ppjmaalit;
        this.vastustajanmaalit = vastustajanmaalit;
       
    }



    public Long getOtteluId() {
        return otteluId;
    }

    public void setOtteluId(Long otteluId) {
        this.otteluId = otteluId;
    }

    public Joukkue getJoukkue() {
        return joukkue;
    }

    public void setJoukkue(Joukkue joukkue) {
        this.joukkue = joukkue;
    }

    public String getOttelutyyppi() {
        return ottelutyyppi;
    }

    public void setOttelutyyppi(String ottelutyyppi) {  
        this.ottelutyyppi = ottelutyyppi;
    }

    public LocalDate getPvm() {
        return pvm;
    }

    public void setPvm(LocalDate pvm) {
        this.pvm = pvm;
    }

    public String getVastustaja() {
        return vastustaja;
    }

    public void setVastustaja(String vastustaja) {
        this.vastustaja = vastustaja;
    }

    public int getPpjmaalit() {
        return ppjmaalit;
    }

    public void setPpjmaalit(int ppjmaalit) {
        this.ppjmaalit = ppjmaalit;
    }

    public int getVastustajanmaalit() {
        return vastustajanmaalit;
    }

    public void setVastustajanmaalit(int vastustajanmaalit) {
        this.vastustajanmaalit = vastustajanmaalit;
    }


    @Override
    public String toString() {
        return "Ottelu{" +
                "otteluId=" + otteluId +
                ", joukkue=" + (joukkue != null ? joukkue.getNimi() : "null") +
                ", ottelutyypi=" + ottelutyyppi +
                ", pvm=" + pvm +
                ", vastustaja='" + vastustaja + '\'' +
                ", ppjmaalit=" + ppjmaalit +
                ", vastustajanmaalit=" + vastustajanmaalit +
                '}';
    }
    
}
