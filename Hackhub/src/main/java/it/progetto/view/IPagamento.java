package it.progetto.view;

import it.progetto.controller.PagamentoController;
import it.progetto.dto.RicevutaDTO;

public interface IPagamento {

    // Metodi chiamati dal sistema o dall'attore per l'interazione
    void mostraModulo();
    
    void sendDati(String iban, String intestatario);
    
    void showRicevuta(RicevutaDTO ricevuta);
    
    void showError(String errore);
}
