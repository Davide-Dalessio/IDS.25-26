package it.progetto.hackhub.repository;

import it.progetto.hackhub.model.RichiestaSupporto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RichiestaSupportoRepository extends JpaRepository<RichiestaSupporto, Integer> {
    List<RichiestaSupporto> findByHackathonId(int hackathonId);
}
