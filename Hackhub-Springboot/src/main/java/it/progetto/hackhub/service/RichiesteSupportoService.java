package it.progetto.hackhub.service;

import it.progetto.hackhub.dto.RichiesteSupportoDTO;
import it.progetto.hackhub.model.Hackathon;
import it.progetto.hackhub.model.RichiestaSupporto;
import it.progetto.hackhub.model.Team;
import it.progetto.hackhub.model.Utente;
import it.progetto.hackhub.repository.HackathonRepository;
import it.progetto.hackhub.repository.RichiestaSupportoRepository;
import it.progetto.hackhub.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RichiesteSupportoService {

    @Autowired
    private RichiestaSupportoRepository richiestaSupportoRepository;

    @Autowired
    private HackathonRepository hackathonRepository;

    @Autowired
    private TeamRepository teamRepository;

    public List<Integer> getAssignedHackathons(int mentorId) {
        List<Hackathon> hackathons = hackathonRepository.findAll();
        List<Integer> assignedIds = new ArrayList<>();
        for (Hackathon h : hackathons) {
            for (Utente m : h.getMentori()) {
                if (m.getId() == mentorId) {
                    assignedIds.add(h.getHackathonId());
                }
            }
        }
        return assignedIds;
    }

    public List<Integer> requestSupportRequests(int mentorId, int hackathonId) {
        checkHackathonExists(hackathonId);
        verifyMentorAssignment(hackathonId, mentorId);

        List<RichiestaSupporto> requests = richiestaSupportoRepository.findByHackathonId(hackathonId);
        if (requests == null || requests.isEmpty()) {
            throw new IllegalArgumentException("Non esistono richieste di supporto per l'hackathon selezionato.");
        }

        return requests.stream().map(RichiestaSupporto::getId).collect(Collectors.toList());
    }

    public RichiesteSupportoDTO getSupportRequestDetails(int mentorId, int hackathonId, int requestId) {
        checkHackathonExists(hackathonId);
        verifyMentorAssignment(hackathonId, mentorId);

        List<RichiestaSupporto> requests = richiestaSupportoRepository.findByHackathonId(hackathonId);
        if (requests == null || requests.isEmpty()) {
            throw new IllegalArgumentException("Non esistono richieste di supporto per l'hackathon selezionato.");
        }

        boolean belongsToHackathon = requests.stream().anyMatch(r -> r.getId() == requestId);
        if (!belongsToHackathon) {
            throw new IllegalArgumentException("La richiesta selezionata non appartiene all'hackathon indicato.");
        }

        RichiestaSupporto request = richiestaSupportoRepository.findById(requestId)
                .orElseThrow(() -> new IllegalArgumentException("Dettagli richiesta non disponibili."));

        Team team = teamRepository.findById(request.getTeamId()).orElse(null);
        String teamName = team != null ? team.getNome() : "Team Sconosciuto";

        return new RichiesteSupportoDTO(
                request.getId(),
                request.getHackathonId(),
                teamName,
                request.getCategoria(),
                request.getData(),
                request.getStato(),
                request.getMsg(),
                request.getDisponibilita(),
                request.getStorico()
        );
    }

    public void checkHackathonExists(int hackathonId) {
        if (!hackathonRepository.existsById(hackathonId)) {
            throw new IllegalArgumentException("L'hackathon selezionato non esiste o non è accessibile.");
        }
    }

    public void verifyMentorAssignment(int hackathonId, int mentorId) {
        Hackathon hackathon = hackathonRepository.findById(hackathonId).orElse(null);
        if (hackathon == null) {
            throw new IllegalArgumentException("Il Mentore non è assegnato all'hackathon selezionato.");
        }
        boolean isMentor = false;
        for (Utente mentore : hackathon.getMentori()) {
            if (mentore.getId() == mentorId) {
                isMentor = true;
                break;
            }
        }
        if (!isMentor) {
            throw new IllegalArgumentException("Il Mentore non è assegnato all'hackathon selezionato.");
        }
    }
}
