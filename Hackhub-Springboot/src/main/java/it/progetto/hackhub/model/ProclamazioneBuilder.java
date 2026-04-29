package it.progetto.hackhub.model;

public interface ProclamazioneBuilder {
    void reset();
    void setOrganizzatoreId(int id);
    void setHackathonId(int id);
    void setTeamId(int id);
    Proclamazione getResult();
}
