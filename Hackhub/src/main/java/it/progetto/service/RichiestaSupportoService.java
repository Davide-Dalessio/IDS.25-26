package it.progetto.service;

import it.progetto.dto.RichiestaSupportoDTO;
import it.progetto.dto.RichiestaSupportoRequest;
import it.progetto.model.Hackathon;
import it.progetto.model.RichiestaSupporto;
import it.progetto.model.Utente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RichiestaSupportoService {

    private final Map<Integer, String> statoHackathonMap = new HashMap<>();
    private final List<RichiestaSupporto> richiesteRepository = new ArrayList<>();

    public RichiestaSupportoService() {
        statoHackathonMap.put(1, "IN_CORSO");
        statoHackathonMap.put(2, "IN_ISCRIZIONE");
        statoHackathonMap.put(3, "IN_VALUTAZIONE");
    }

    public void checkDati(int teamId, int hackathonId) {
        checkhackathonState(hackathonId);
    }

    private void checkhackathonState(int hackathonId) {
        String stato = statoHackathonMap.get(hackathonId);
        if (!"IN_CORSO".equals(stato)) {
            throw new IllegalStateException("Hackathon non in corso");
        }
    }

    public RichiestaSupportoDTO requestRichiesta(RichiestaSupportoRequest request) {
        RichiestaSupporto richiesta = new RichiestaSupporto(request.getTeamId(), request.getHackathonId(),
                request.getMsg());

        save(richiesta);

        Hackathon hackathon = getHackathonById(request.getHackathonId());
        hackathon.notificaMentori(request.getHackathonId());

        return new RichiestaSupportoDTO(request.getTeamId(), request.getHackathonId(), "Aperta");
    }

    private void save(RichiestaSupporto richiesta) {
        richiesteRepository.add(richiesta);
        System.out.println("RichiestaSupportoService: [MOCK-DB] Richiesta salvata -> Team " + richiesta.getTeamId()
                + " Hackathon " + richiesta.getHackathonId());
    }

    private Hackathon getHackathonById(int hackathonId) {
        Hackathon h = new Hackathon();
        h.setNome("Hackathon " + hackathonId);
        h.getEvents().subscribe("nuova_richiesta", new Utente(10, "Mentore Rossi", "rossi@mentor.com"));
        h.getEvents().subscribe("nuova_richiesta", new Utente(11, "Mentore Bianchi", "bianchi@mentor.com"));
        return h;
    }
}
