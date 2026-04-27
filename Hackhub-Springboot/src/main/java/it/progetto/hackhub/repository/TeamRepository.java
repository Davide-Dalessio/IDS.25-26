package it.progetto.hackhub.repository;

import it.progetto.hackhub.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
    boolean existsByNome(String nome);
    boolean existsByMembri_Id(int utenteId);
    Optional<Team> findByMembri_Id(int utenteId);
}
