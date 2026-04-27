package it.progetto.hackhub.repository;

import it.progetto.hackhub.model.Invito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvitoRepository extends JpaRepository<Invito, Integer> {
}
