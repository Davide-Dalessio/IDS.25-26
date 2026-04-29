package it.progetto.hackhub.controller;

import it.progetto.hackhub.dto.AccessoSottomissioniDTO;
import it.progetto.hackhub.dto.AccessoSottomissioniRequest;
import it.progetto.hackhub.service.AccessoSottomissioniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accessosottomissioni")
public class AccessoSottomissioniController {

    private final AccessoSottomissioniService accessoSottomissioniService;

    @Autowired
    public AccessoSottomissioniController(AccessoSottomissioniService accessoSottomissioniService) {
        this.accessoSottomissioniService = accessoSottomissioniService;
    }

    @PostMapping("/lista")
    public List<AccessoSottomissioniDTO> getSubmissionsList(@RequestBody AccessoSottomissioniRequest request) {
        return accessoSottomissioniService.getSubmissionsList(request);
    }
}
