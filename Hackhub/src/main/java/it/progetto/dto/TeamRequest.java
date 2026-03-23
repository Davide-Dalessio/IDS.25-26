package it.progetto.dto;

public class TeamRequest {
    private String nomeTeam;
    private int utenteID;

    public TeamRequest(String nomeTeam, int utenteID) {
        this.nomeTeam = nomeTeam;
        this.utenteID = utenteID;
    }

    public TeamRequest() {}

    public String getNomeTeam() {return nomeTeam;}
    public int getUtenteID() {return utenteID;}

    public void setNomeTeam(String nomeTeam) {this.nomeTeam = nomeTeam;}
    public void setUtenteID(int utenteID) {this.utenteID = utenteID;}
}