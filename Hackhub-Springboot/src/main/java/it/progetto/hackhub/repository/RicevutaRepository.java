package it.progetto.hackhub.repository;

import it.progetto.hackhub.model.Ricevuta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RicevutaRepository extends JpaRepository<Ricevuta, Integer> {
}
