package it.progetto.hackhub.repository;

import it.progetto.hackhub.model.Sottomissione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SottomissioneRepository extends JpaRepository<Sottomissione, Integer> {
    java.util.Optional<Sottomissione> findByTeam_TeamIdAndHackathon_HackathonId(int teamId, int hackathonId);
}
