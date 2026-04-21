package it.progetto.view;

public interface IRegistrazione {
    void mostraModulo();
    
    void sendDati(String nome, String email, String password);
    
    void mostraConferma();
    
    void mostraErrore(String errore);
}
