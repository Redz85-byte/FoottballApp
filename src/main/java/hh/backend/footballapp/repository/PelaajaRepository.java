package hh.backend.footballapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hh.backend.footballapp.domain.Pelaaja;

@Repository
public interface PelaajaRepository extends JpaRepository<Pelaaja, Long> { //Jpa lisätekniikkaa hyödynnetään

    List<Pelaaja> findByJoukkueId(int joukkueId); 

}