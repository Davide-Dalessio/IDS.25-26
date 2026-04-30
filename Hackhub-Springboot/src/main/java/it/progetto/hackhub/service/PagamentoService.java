package it.progetto.hackhub.service;

import it.progetto.hackhub.dto.PagamentoRequest;
import it.progetto.hackhub.dto.RicevutaDTO;
import it.progetto.hackhub.model.Ricevuta;
import it.progetto.hackhub.repository.RicevutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PagamentoService {

    @Autowired
    private RicevutaRepository ricevutaRepository;

    @Autowired
    private SistemaDiPagamento sistemaDiPagamento;

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
        ricevutaRepository.save(ricevuta);

        return new RicevutaDTO("Transazione Completata", premio);
    }
}
