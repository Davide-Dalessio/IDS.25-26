package it.progetto.hackhub.controller;

import it.progetto.hackhub.dto.PagamentoRequest;
import it.progetto.hackhub.dto.RicevutaDTO;
import it.progetto.hackhub.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pagamenti")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping("/paga")
    public ResponseEntity<?> requestPagamento(@RequestBody PagamentoRequest request) {
        try {
            RicevutaDTO ricevutaDTO = pagamentoService.requestPagamento(request);
            return ResponseEntity.ok(ricevutaDTO);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
