package it.progetto.controller;

import it.progetto.dto.PagamentoRequest;
import it.progetto.dto.RicevutaDTO;
import it.progetto.service.PagamentoService;
import it.progetto.view.IPagamento;

public class PagamentoController {

    private final PagamentoService pagamentoService;
    private final IPagamento view;

    public PagamentoController(IPagamento view) {
        this.pagamentoService = new PagamentoService();
        this.view = view;
    }

    private PagamentoRequest createPagamento(String iban, String intestatario) {
        int hackathonId = 1;
        return new PagamentoRequest(iban, intestatario, hackathonId);
    }

    public void requestPagamento(PagamentoRequest request) {
        try {
            RicevutaDTO ricevutaDTO = pagamentoService.requestPagamento(request);
            view.showRicevuta(ricevutaDTO);
        } catch (IllegalArgumentException e) {
            view.showError(e.getMessage());
        }
    }

    public void sendDati(String iban, String intestatario) {
        PagamentoRequest request = createPagamento(iban, intestatario);
        requestPagamento(request);
    }
}
