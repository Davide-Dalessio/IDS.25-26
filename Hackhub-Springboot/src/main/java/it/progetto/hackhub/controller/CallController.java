package it.progetto.hackhub.controller;

import it.progetto.hackhub.dto.CallDTO;
import it.progetto.hackhub.dto.CallRequest;
import it.progetto.hackhub.service.CallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calls")
public class CallController {

    @Autowired
    private CallService callService;

    @PostMapping("/create")
    public ResponseEntity<?> sendDatiCall(@RequestBody CallRequest request) {
        try {
            CallDTO dto = callService.requestCall(request);
            return ResponseEntity.ok(dto);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
