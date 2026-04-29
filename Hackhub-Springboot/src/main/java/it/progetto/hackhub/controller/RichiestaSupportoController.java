package it.progetto.hackhub.controller;

import it.progetto.hackhub.dto.RichiestaSupportoDTO;
import it.progetto.hackhub.dto.RichiestaSupportoRequest;
import it.progetto.hackhub.service.RichiestaSupportoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/supporto")
public class RichiestaSupportoController {

    @Autowired
    private RichiestaSupportoService richiestaSupportoService;

    @PostMapping("/richiesta")
    public ResponseEntity<?> requestRichiesta(@RequestBody RichiestaSupportoRequest request) {
        try {
            richiestaSupportoService.checkDati(request.getTeamId(), request.getHackathonId());
            RichiestaSupportoDTO dto = richiestaSupportoService.requestRichiesta(request);
            return ResponseEntity.ok(dto);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
