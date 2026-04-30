package it.progetto.hackhub.controller;

import it.progetto.hackhub.dto.SlotDTO;
import it.progetto.hackhub.dto.SlotRequest;
import it.progetto.hackhub.service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/slots")
public class SlotController {

    @Autowired
    private SlotService slotService;

    @PostMapping("/book")
    public ResponseEntity<?> sendSlotSelection(@RequestBody SlotRequest request) {
        try {
            SlotDTO dto = slotService.bookSlot(request);
            return ResponseEntity.ok(dto);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
