package it.progetto.hackhub.repository;

import it.progetto.hackhub.model.Partecipazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartecipazioneRepository extends JpaRepository<Partecipazione, Integer> {
    boolean existsByTeam_TeamIdAndHackathon_HackathonId(int teamId, int hackathonId);
}
