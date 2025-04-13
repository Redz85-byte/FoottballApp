package hh.backend.footballapp.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity

public class Pelaaja {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pelaajaId;

    @NotNull(message = "Nimi ei voi olla tyhjä")
    @Size(min = 5, max = 30, message = "Nimi pitää olla 5 ja 30 merkin välillä")
    private String nimi;

    @NotNull(message = "Pituus ei voi olla tyhjä")
    @DecimalMin(value = "1.0", message = "Pituuden tulee olla vähintään 1 metri")
    @DecimalMax(value = "2.5", message = "Pituuden tulee olla enintään 2.5 metriä")
    private double pituus;

    @NotNull(message = "Pelipaikka ei voi olla tyhjä")
    private String pelipaikka;

    @NotNull(message = "Pelinumero ei voi olla tyhjä")
    @Min(value = 1, message = "Pelinumero ei voi olla pienempi kuin 1")
    @Max(value = 99, message = "Pelinumero ei voi olla suurempi kuin 99")
    private int pelinumero;


    @ManyToOne
    @JoinColumn(name ="joukkue_id")
    private Joukkue joukkue;


    public Pelaaja() {
    } //parametritön konstruktori

    public Pelaaja(String nimi, double pituus, String pelipaikka, int pelinumero, Joukkue joukkue) {
        super();
        this.nimi = nimi;
        this.pituus = pituus;
        this.pelipaikka = pelipaikka;
        this.pelinumero = pelinumero;
        this.joukkue = joukkue;

    } //Parametrillinen konstuktori
    public Long getPelaajaId() {
        return pelaajaId;
    }

    public void setPelaajaId(Long pelaajaId) {
        this.pelaajaId = pelaajaId;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public double getPituus() {
        return pituus;
    }

    public void setPituus(double pituus) {
        this.pituus = pituus;
    }

    public String getPelipaikka() {
        return pelipaikka;
    }

    public void setPelipaikka(String pelipaikka) {
        this.pelipaikka = pelipaikka;
    }

    public int getPelinumero() {
        return pelinumero;
    }

    public void setPelinumero(int pelinumero) {
        this.pelinumero = pelinumero;
    }


    public Joukkue getJoukkue() {
        return joukkue;
    }

    public void setJoukkue(Joukkue joukkue) {
        this.joukkue = joukkue;
    }

    @Override
    public String toString() {
        return "Pelaaja{" +
                "pelaajaId=" + pelaajaId +
                ", joukkue=" + (joukkue != null ? joukkue.getNimi() : "null") +
                ", nimi='" + nimi + '\'' +
                ", pituus=" + pituus +
                ", pelipaikka='" + pelipaikka + '\'' +
                ", pelinumero='" + pelinumero + '\'' +
                '}';
 }

}