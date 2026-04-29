package it.progetto.hackhub.controller;

import it.progetto.hackhub.dto.RichiesteSupportoDTO;
import it.progetto.hackhub.dto.RichiesteSupportoRequest;
import it.progetto.hackhub.service.RichiesteSupportoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supporto/mentore")
public class RichiesteSupportoController {

    @Autowired
    private RichiesteSupportoService richiesteSupportoService;

    @GetMapping("/{mentorId}/hackathons")
    public ResponseEntity<List<Integer>> requestAssignedHackathons(@PathVariable int mentorId) {
        List<Integer> hackathons = richiesteSupportoService.getAssignedHackathons(mentorId);
        return ResponseEntity.ok(hackathons);
    }

    @PostMapping("/richieste")
    public ResponseEntity<?> requestSupportRequests(@RequestBody RichiesteSupportoRequest request) {
        try {
            List<Integer> richieste = richiesteSupportoService.requestSupportRequests(request.getMentorId(), request.getHackathonId());
            return ResponseEntity.ok(richieste);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/dettaglio")
    public ResponseEntity<?> getSupportRequestDetails(@RequestBody RichiesteSupportoRequest request) {
        try {
            RichiesteSupportoDTO dto = richiesteSupportoService.getSupportRequestDetails(request.getMentorId(), request.getHackathonId(), request.getRequestId());
            return ResponseEntity.ok(dto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
