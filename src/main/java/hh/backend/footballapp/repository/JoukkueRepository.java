package hh.backend.footballapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hh.backend.footballapp.domain.Joukkue;

@Repository
public interface JoukkueRepository extends CrudRepository<Joukkue, Long> {

}
