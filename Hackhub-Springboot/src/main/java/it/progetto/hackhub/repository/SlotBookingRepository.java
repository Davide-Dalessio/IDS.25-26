package it.progetto.hackhub.repository;

import it.progetto.hackhub.model.SlotBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotBookingRepository extends JpaRepository<SlotBooking, Integer> {
}
