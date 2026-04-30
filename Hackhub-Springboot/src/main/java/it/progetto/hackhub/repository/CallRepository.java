package it.progetto.hackhub.repository;

import it.progetto.hackhub.model.Call;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CallRepository extends JpaRepository<Call, Integer> {
    boolean existsByRequestId(int requestId);
}
