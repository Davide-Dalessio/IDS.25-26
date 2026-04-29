package it.progetto.hackhub.service;

import it.progetto.hackhub.dto.AccessoSottomissioniDTO;
import it.progetto.hackhub.dto.AccessoSottomissioniRequest;
import it.progetto.hackhub.model.Hackathon;
import it.progetto.hackhub.repository.HackathonRepository;
import it.progetto.hackhub.repository.SottomissioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccessoSottomissioniService {

    private final HackathonRepository hackathonRepository;
    private final SottomissioneRepository sottomissioneRepository;

    @Autowired
    public AccessoSottomissioniService(HackathonRepository hackathonRepository, SottomissioneRepository sottomissioneRepository) {
        this.hackathonRepository = hackathonRepository;
        this.sottomissioneRepository = sottomissioneRepository;
    }

    public List<AccessoSottomissioniDTO> getSubmissionsList(AccessoSottomissioniRequest request) {

        Hackathon hackathon = hackathonRepository.findById(request.getHackathonId())
                .orElseThrow(() -> new IllegalArgumentException("L'hackathon selezionato non esiste."));


        verifyStaffAssignment(hackathon, request.getStaffId());

        List<AccessoSottomissioniDTO> sottomissioni = sottomissioneRepository.findAll().stream()
                .filter(s -> s.getHackathon().getHackathonId() == request.getHackathonId())
                .filter(s -> s.getLink() != null && !s.getLink().isBlank())
                .map(s -> new AccessoSottomissioniDTO(
                        s.getSottomissioneId(),
                        s.getTeam().getTeamId(),
                        s.getLink()
                ))
                .collect(Collectors.toList());

        if (sottomissioni.isEmpty()) {
            throw new IllegalArgumentException("Nessuna sottomissione presente per questo hackathon.");
        }

        return sottomissioni;
    }

    private void verifyStaffAssignment(Hackathon hackathon, int staffId) {
        boolean isMentor = hackathon.getMentori() != null && hackathon.getMentori().stream().anyMatch(u -> u.getId() == staffId);
        boolean isGiudice = hackathon.getGiudici() != null && hackathon.getGiudici().stream().anyMatch(u -> u.getId() == staffId);
        
        if (!isMentor && !isGiudice && hackathon.getOrganizzatoreID() != staffId) {
            throw new IllegalArgumentException("Il membro dello staff non è assegnato all'hackathon selezionato.");
        }
    }
}
