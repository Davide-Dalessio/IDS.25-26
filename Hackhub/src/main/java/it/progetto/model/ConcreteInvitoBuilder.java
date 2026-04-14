package it.progetto.model;

public class ConcreteInvitoBuilder implements InvitoBuilder {
    private Invito invito;

    public ConcreteInvitoBuilder() {
        this.reset();
    }

    @Override
    public void reset() {
        this.invito = new Invito();
    }

    @Override
    public void setMittente(int mittenteID) {
        this.invito.setMittenteID(mittenteID);
    }

    @Override
    public void setUtenteInvitato(int utenteID) {
        this.invito.setUtenteID(utenteID);
    }

    @Override
    public Invito getResult() {
        Invito result = this.invito;
        this.reset();
        return result;
    }
}
