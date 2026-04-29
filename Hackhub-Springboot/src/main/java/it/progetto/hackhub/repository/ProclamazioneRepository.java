package it.progetto.hackhub.repository;

import it.progetto.hackhub.model.Proclamazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProclamazioneRepository extends JpaRepository<Proclamazione, Integer> {
}
