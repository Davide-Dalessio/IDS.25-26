package it.progetto.hackhub.repository;

import it.progetto.hackhub.model.Valutazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ValutazioneRepository extends JpaRepository<Valutazione, Integer> {
    List<Valutazione> findByHackathonId(int hackathonId);
    boolean existsBySubmissionIdAndGiudiceId(int submissionId, int giudiceId);
}
