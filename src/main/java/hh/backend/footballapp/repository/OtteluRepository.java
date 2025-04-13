package hh.backend.footballapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hh.backend.footballapp.domain.Ottelu;


@Repository
public interface OtteluRepository extends CrudRepository<Ottelu, Long> {
    public List<Ottelu> findByJoukkueId(long l);

}
