package hh.backend.footballapp.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Joukkue {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nimi;

    @OneToMany(mappedBy = "joukkue") 
    private List<Pelaaja> pelaajat; //1 joukkueeseen voidaan lisätä monia pelaajia (JPA lisä tekniikka)

    public Joukkue() {}

    public Joukkue(String nimi) {
        this.nimi = nimi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public List<Pelaaja> getPelaajat() {
        return pelaajat;
    }

    public void setPelaajat(List<Pelaaja> pelaajat) {
        this.pelaajat = pelaajat;
    }

    @Override
    public String toString() {
        return "Joukkue{" +
                "id=" + id +
                ", nimi='" + nimi + '\'' +
                '}';
    }
}
