package it.progetto.hackhub.service;

import it.progetto.hackhub.dto.RichiestaSupportoDTO;
import it.progetto.hackhub.dto.RichiestaSupportoRequest;
import it.progetto.hackhub.model.Hackathon;
import it.progetto.hackhub.model.RichiestaSupporto;
import it.progetto.hackhub.model.Utente;
import it.progetto.hackhub.repository.HackathonRepository;
import it.progetto.hackhub.repository.RichiestaSupportoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RichiestaSupportoService {

    @Autowired
    private RichiestaSupportoRepository richiestaSupportoRepository;

    @Autowired
    private HackathonRepository hackathonRepository;

    public void checkDati(int teamId, int hackathonId) {
        checkhackathonState(hackathonId);
    }

    private void checkhackathonState(int hackathonId) {
        Hackathon hackathon = hackathonRepository.findById(hackathonId)
                .orElseThrow(() -> new IllegalArgumentException("L'hackathon selezionato non esiste o non è accessibile."));
        if (!"IN_CORSO".equals(hackathon.getStato().name())) {
            throw new IllegalStateException("Hackathon non in corso");
        }
    }

    public RichiestaSupportoDTO requestRichiesta(RichiestaSupportoRequest request) {
        RichiestaSupporto richiesta = new RichiestaSupporto(request.getTeamId(), request.getHackathonId(), request.getMsg());
        richiesta = richiestaSupportoRepository.save(richiesta);

        Hackathon hackathon = hackathonRepository.findById(request.getHackathonId()).orElse(null);
        if (hackathon != null) {
            for (Utente mentore : hackathon.getMentori()) {
                NotificaUtenteObserver observer = new NotificaUtenteObserver(mentore.getId());
                observer.update("Nuova richiesta di supporto creata per l'hackathon " + hackathon.getNome());
            }
        }

        return new RichiestaSupportoDTO(request.getTeamId(), request.getHackathonId(), "Aperta");
    }
}
