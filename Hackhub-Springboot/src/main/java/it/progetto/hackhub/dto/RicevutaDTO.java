package it.progetto.hackhub.dto;

public class RicevutaDTO {
    private String esito;
    private double importo;

    public RicevutaDTO() {
    }

    public RicevutaDTO(String esito, double importo) {
        this.esito = esito;
        this.importo = importo;
    }

    public String getEsito() {
        return esito;
    }

    public void setEsito(String esito) {
        this.esito = esito;
    }

    public double getImporto() {
        return importo;
    }

    public void setImporto(double importo) {
        this.importo = importo;
    }
}
