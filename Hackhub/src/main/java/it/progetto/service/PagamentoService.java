package it.progetto.service;

import it.progetto.dto.PagamentoRequest;
import it.progetto.dto.RicevutaDTO;
import it.progetto.model.Ricevuta;

public class PagamentoService {

    private final SistemaDiPagamento sistemaDiPagamento = new SistemaDiPagamento();

    public RicevutaDTO requestPagamento(PagamentoRequest request) {
        checkdati(request);

        double premio = 1000.00;

        elaboraTransazione(request.getIban(), premio);

        return newRicevuta(request, premio);
    }

    public void checkdati(PagamentoRequest request) {
        if (request.getIban() == null || request.getIban().isEmpty() || request.getIban().length() < 15) {
            throw new IllegalArgumentException("Dati bancari non validi: IBAN errato.");
        }
        if (request.getIntestatario() == null || request.getIntestatario().isEmpty()) {
            throw new IllegalArgumentException("Dati bancari non validi: Intestatario mancante.");
        }
    }

    private void elaboraTransazione(String iban, double premio) {
        sistemaDiPagamento.elaboraTransazione(iban, premio);
    }

    private RicevutaDTO newRicevuta(PagamentoRequest request, double premio) {

        Ricevuta ricevuta = new Ricevuta(request.getHackathonId(), request.getIban(), premio);

        System.out.println("   [DB - PAGAMENTI] Salvata nuova Ricevuta per Hackathon " + request.getHackathonId());

        return new RicevutaDTO("Transazione Completata", premio);
    }
}
