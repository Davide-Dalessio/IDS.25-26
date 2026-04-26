package it.progetto.model;

public class ConcreteProclamazioneBuilder implements ProclamazioneBuilder {
    private int organizzatoreId;
    private int hackathonId;
    private int teamId;

    public ConcreteProclamazioneBuilder() {
        this.reset();
    }

    @Override
    public void reset() {
        this.organizzatoreId = 0;
        this.hackathonId = 0;
        this.teamId = 0;
    }

    @Override
    public void setOrganizzatoreId(int id) {
        this.organizzatoreId = id;
    }

    @Override
    public void setHackathonId(int id) {
        this.hackathonId = id;
    }

    @Override
    public void setTeamId(int id) {
        this.teamId = id;
    }

    @Override
    public Proclamazione getResult() {
        Proclamazione result = new Proclamazione(organizzatoreId, hackathonId, teamId);
        this.reset();
        return result;
    }
}
